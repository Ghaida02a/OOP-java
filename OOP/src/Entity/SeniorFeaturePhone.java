package Entity;

public class SeniorFeaturePhone extends FeaturePhone {
    private int largeButtonSize; //e.g., mm size.
    private boolean sosButton;
    private boolean hearingAidCompatibility;

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

    public boolean isHearingAidCompatibility() {
        return hearingAidCompatibility;
    }

    public void setHearingAidCompatibility(boolean hearingAidCompatibility) {
        this.hearingAidCompatibility = hearingAidCompatibility;
    }
}
