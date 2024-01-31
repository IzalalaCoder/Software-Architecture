public class Client01 {

    // Attributs

    private ImagingDevice device;

    // Constructeur

    public Client01() {
        this.device = null;
    }

    // Requêtes

    public ImagingDevice getDevice() {
        return this.device;
    }

    // Commandes

    public void setDevice(ImagingDevice device) {
        if (device == null) {
            throw new AssertionError();
        }

        this.device = device;
    }

    public void unsetDevice() {
        this.device = null;
    }
}
