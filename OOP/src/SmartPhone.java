public class SmartPhone extends Phone {
    private Integer smartPhoneId;
    private String operatingSystem;
    private boolean bluetoothAvailable;

    public Integer getSmartPhoneId() {
        return smartPhoneId;
    }

    public void setSmartPhoneId(Integer smartPhoneId) {
        this.smartPhoneId = smartPhoneId;
    }

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
