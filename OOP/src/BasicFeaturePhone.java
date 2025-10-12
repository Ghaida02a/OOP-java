public class BasicFeaturePhone extends FeaturePhone {
    private String primaryFunction;
    private boolean colorScreen;
    private boolean fmRadio;

    public String getPrimaryFunction() {
        return primaryFunction;
    }

    public void setPrimaryFunction(String primaryFunction) {
        this.primaryFunction = primaryFunction;
    }

    public boolean isColorScreen() {
        return colorScreen;
    }

    public void setColorScreen(boolean colorScreen) {
        this.colorScreen = colorScreen;
    }

    public boolean isFmRadio() {
        return fmRadio;
    }

    public void setFmRadio(boolean fmRadio) {
        this.fmRadio = fmRadio;
    }
}
