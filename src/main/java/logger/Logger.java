package logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

/**
 * Created by taras on 9/30/16.
 */
public class Logger {

    private  StringBuilder testSteps = new StringBuilder();
    private  StringBuilder human = new StringBuilder();
    private  StringBuilder technical = new StringBuilder();
    private  StringBuilder xml = new StringBuilder();
    private  String customName = new String();
    private  IXmlLogger customLogger = null;

    private  String fullTestName = new String();
    private  ITestResult testResult = null;
    private  ITestContext testContext = null;
    private  String outputDirectory = new String();
    private  String testClassName = new String();
    private  String testName = new String();

    public enum Level {
        ERROR("[ERROR] "),
        FAILURE("[FAILURE] "),
        INFO("[INFO] "),
        WARNING("[WARNING] "),
        STEP("[STEP] ");

        private String level;

        private Level(String level) {
            this.level = level;
        }

        public String getLevel() {
            return this.level;
        }

    }

    public void setTestContext(final ITestContext context) {
        testContext = context;
        outputDirectory = context.getOutputDirectory();
        Reporter.log(String.format("Starting logging in '%s'", outputDirectory), true);
    }

    public void startTest(final String fullTestName, final ITestResult testResult, final String testClassName, final String testName, final String brandName) {
        this.fullTestName = fullTestName;
        this.testResult = testResult;

        this.setDetailedName(testClassName, testName, brandName);

    }

    private  void setDetailedName(final String testClassName, final String testName, final String brandName) {
        //To change body of created methods use File | Settings | File Templates.
        this.testClassName = testClassName;
        this.testName = testName;
    }

    public  void endTest() {
        writeLogFile(human, "human", "log");
        writeLogFile(technical, "technical", "log");
        writeLogFile(testSteps, "steps", "log");

        human = null;
        technical = null;
        testSteps = null;
    }

    private  void writeLogFile(final StringBuilder source, final String name, final String extension) {
        if (source != null) {
            final File logBrandDirectory = new File(outputDirectory);
            final File logClassDirectory = new File(logBrandDirectory, testClassName);
            final File logDirectory = new File(logClassDirectory, testName);
            logDirectory.mkdirs();
            final File logFile = new File(logDirectory, name + "." + extension);
            try {
                final FileWriter writer = new FileWriter(logFile);
                writer.write(source.toString());
                writer.close();
            } catch (IOException exception) {
                Reporter.log(String.format("Cannot write log to file: '%s'", logFile.toString()), true);
            }
        }
    }

    public  void logHuman(final String message) {
        ensureHuman();
        ensureTechnical();
        appendLn(human, message);
        appendLn(technical, message);
    }

    public  void logHuman(Level level, final String message, boolean logToOutput) {
        logHuman(level.getLevel() + message, logToOutput);
    }

    public  void logHuman(final String message, boolean logToOutput) {
        logHuman(message);
        if (logToOutput)
            logToOutput(message);
    }

    public  void logToOutput(final String message) {
        Reporter.log(getCurrentTime() + message, true);
    }

    public  void logStep(final String message) {
        ensureSteps();
        appendLn(testSteps, Level.STEP.getLevel() + message);
        logHuman(Level.STEP.getLevel() + message, true);
    }

    public  void logTechnical(final String message) {
        ensureTechnical();
        appendLn(technical, message);
    }

    private  String format(final String formatString, final Object[] args) {
        return String.format(formatString, args);
    }

    public  void logHuman(final String message, final Object... args) {
        final String formattedMessage = format(message, args);
        logHuman(formattedMessage);
    }

    public  void logTechnical(final String message, final Object... args) {
        final String formattedMessage = format(message, args);
        logTechnical(formattedMessage);
    }

    private  void appendLn(final StringBuilder log, final String message) {
        final StringBuilder builder = log;
        builder.append(getCurrentTime() + message);
        builder.append("\n");
    }

    private  void ensureTechnical() {
        if (technical == null) {
            technical = new StringBuilder();
        }
    }

    private  void ensureHuman() {
        if (human == null) {
            human = new StringBuilder();
        }
    }

    private  void ensureSteps() {
        if (testSteps == null) {
            testSteps = new StringBuilder();
        }
    }

    public  void initializeCustom(final String name) {
        xml = new StringBuilder();
        customName = name;
        customLogger = new CustomXmlLogger();
    }

    public  IXmlLogger custom() {
        return customLogger;
    }

    public  void flushCustom() {
        writeLogFile(xml, customName, "xml");
    }

    public  String getLogDirectory() {
        return outputDirectory + "//" + testClassName + "//" + testName;
    }

    public interface IXmlLogger {
        void begin(final String name);

        void end();

        void item(String name, String content);
    }

    private  class CustomXmlLogger implements IXmlLogger {

        private final Stack<String> elements = new Stack<String>();

        @Override
        public void begin(String name) {
            appendLn(xml, "<" + name + ">\n");
            elements.push(name);
        }

        @Override
        public void end() {
            final String elementName = elements.pop();
            appendLn(xml, "</" + elementName + ">\n");
        }

        @Override
        public void item(final String name, final String content) {
            appendLn(xml, "<" + name + ">" + content + "</" + name + ">");
        }
    }

    private  String getCurrentTime() {
        long millisec = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM HH:mm:ss");

        Date date = new Date(millisec);

        return "[" + sdf.format(date) + "]";

    }
}
