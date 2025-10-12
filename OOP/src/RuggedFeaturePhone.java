public class RuggedFeaturePhone extends FeaturePhone{
    private int ipRating;
    private float dropTestHeight; //Height in meters or feet
    private int batteryStandbyDays;

    public int getIpRating() {
        return ipRating;
    }

    public void setIpRating(int ipRating) {
        this.ipRating = ipRating;
    }

    public float getDropTestHeight() {
        return dropTestHeight;
    }

    public void setDropTestHeight(float dropTestHeight) {
        this.dropTestHeight = dropTestHeight;
    }

    public int getBatteryStandbyDays() {
        return batteryStandbyDays;
    }

    public void setBatteryStandbyDays(int batteryStandbyDays) {
        this.batteryStandbyDays = batteryStandbyDays;
    }
}
