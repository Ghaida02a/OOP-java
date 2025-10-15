package Entity;

public class CloudGamingPhone extends GamingPhone {
    private String wifiStandard;
    private boolean FiveGBandSupport;
    private String subscriptionBundle;

    public String getWifiStandard() {
        return wifiStandard;
    }

    public void setWifiStandard(String wifiStandard) {
        this.wifiStandard = wifiStandard;
    }

    public boolean isFiveGBandSupport() {
        return FiveGBandSupport;
    }

    public void setFiveGBandSupport(boolean fiveGBandSupport) {
        FiveGBandSupport = fiveGBandSupport;
    }

    public String getSubscriptionBundle() {
        return subscriptionBundle;
    }

    public void setSubscriptionBundle(String subscriptionBundle) {
        this.subscriptionBundle = subscriptionBundle;
    }
}
