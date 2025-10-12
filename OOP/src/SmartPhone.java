public class SmartPhone extends Phone {
    private String operatingSystem;
    private boolean bluetoothAvailable;

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public boolean isBluetoothAvailable() {
        return bluetoothAvailable;
    }

    public void setBluetoothAvailable(boolean bluetoothAvailable) {
        this.bluetoothAvailable = bluetoothAvailable;
    }
}
