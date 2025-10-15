package Entity;

public class FlagshipPhone extends SmartPhone {
    private String processorModel;
    private String biometricSecurity; //"Fingerprint, FaceID"
    private float wirelessChargingSpeed; //Measured in watts

    public String getProcessorModel() {
        return processorModel;
    }

    public void setProcessorModel(String processorModel) {
        this.processorModel = processorModel;
    }

    public String getBiometricSecurity() {
        return biometricSecurity;
    }

    public void setBiometricSecurity(String biometricSecurity) {
        this.biometricSecurity = biometricSecurity;
    }

    public float getWirelessChargingSpeed() {
        return wirelessChargingSpeed;
    }

    public void setWirelessChargingSpeed(float wirelessChargingSpeed) {
        this.wirelessChargingSpeed = wirelessChargingSpeed;
    }
}
