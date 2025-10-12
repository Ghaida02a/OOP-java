public class SeniorFeaturePhone extends FeaturePhone{
    private int largeButtonSize; //e.g., mm size.
    private boolean sosButton;
    private int hearingAidCompatibility;

    public int getLargeButtonSize() {
        return largeButtonSize;
    }

    public void setLargeButtonSize(int largeButtonSize) {
        this.largeButtonSize = largeButtonSize;
    }

    public boolean isSosButton() {
        return sosButton;
    }

    public void setSosButton(boolean sosButton) {
        this.sosButton = sosButton;
    }

    public int getHearingAidCompatibility() {
        return hearingAidCompatibility;
    }

    public void setHearingAidCompatibility(int hearingAidCompatibility) {
        this.hearingAidCompatibility = hearingAidCompatibility;
    }
}
