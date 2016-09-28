package driver;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by taras on 9/27/16.
 */
@XmlRootElement
public class Devices {

    ArrayList<Device> device;

    public ArrayList<Device> getDevice() {
        return device;
    }

    @XmlElement
    public void setDevice(ArrayList<Device> device) {
        this.device = device;
    }
}
