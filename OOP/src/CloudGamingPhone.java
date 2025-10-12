public class CloudGamingPhone extends GamingPhone {
    private String wifiStandard;
    private String FiveGBandSupport;
    private boolean subscriptionBundle;

    public String getWifiStandard() {
        return wifiStandard;
    }

    public void setWifiStandard(String wifiStandard) {
        this.wifiStandard = wifiStandard;
    }

    public String getFiveGBandSupport() {
        return FiveGBandSupport;
    }

    public void setFiveGBandSupport(String fiveGBandSupport) {
        FiveGBandSupport = fiveGBandSupport;
    }

    public boolean isSubscriptionBundle() {
        return subscriptionBundle;
    }

    public void setSubscriptionBundle(boolean subscriptionBundle) {
        this.subscriptionBundle = subscriptionBundle;
    }
}
