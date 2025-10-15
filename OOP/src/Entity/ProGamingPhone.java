package Entity;

public class ProGamingPhone extends GamingPhone {
    private String shoulderTriggers; //Physical or touch-sensitive buttons
    private String coolingSystemType; //"Fan", "Liquid Cooling".

    public String getShoulderTriggers() {
        return shoulderTriggers;
    }

    public void setShoulderTriggers(String shoulderTriggers) {
        this.shoulderTriggers = shoulderTriggers;
    }

    public String getCoolingSystemType() {
        return coolingSystemType;
    }

    public void setCoolingSystemType(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }
}
