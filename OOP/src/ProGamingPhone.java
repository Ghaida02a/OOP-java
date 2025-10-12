public class ProGamingPhone extends GamingPhone {
    private boolean shoulderTriggers;
    private String coolingSystemType; //"Fan", "Liquid Cooling".

    public boolean isShoulderTriggers() {
        return shoulderTriggers;
    }

    public void setShoulderTriggers(boolean shoulderTriggers) {
        this.shoulderTriggers = shoulderTriggers;
    }

    public String getCoolingSystemType() {
        return coolingSystemType;
    }

    public void setCoolingSystemType(String coolingSystemType) {
        this.coolingSystemType = coolingSystemType;
    }
}
