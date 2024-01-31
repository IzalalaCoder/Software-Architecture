import java.util.ArrayList;
import java.util.List;

public class Client0N {
    
    // Attributs

    private List<ImagingDevice> devices;
    
    // Constructeurs

    public Client0N() {
        this.devices = new ArrayList<ImagingDevice>();
    }

    // Reqêtes

    public ImagingDevice getImagingDevice(int index) {
        if (notAssertIndex(index)) {
            throw new AssertionError();
        }

        return this.devices.get(index);
    }

    // Commandes

    public void addDevice(ImagingDevice device) {
        if (device == null) {
            throw new AssertionError();
        }

        this.devices.add(device);
    }

    public void removeDevice(int index) {
        if (notAssertIndex(index)) {
            throw new AssertionError();
        }

        this.devices.remove(index);
    }

    // Outils

    private Boolean notAssertIndex(int index) {
        return index < 0 || index >= this.devices.size();
    }

}
