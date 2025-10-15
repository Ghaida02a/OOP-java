package Entity;

public class BasicFeaturePhone extends FeaturePhone {
    private String primaryFunction;
    private String colorScreen;
    private boolean fmRadio;

    public String getPrimaryFunction() {
        return primaryFunction;
    }

    public void setPrimaryFunction(String primaryFunction) {
        this.primaryFunction = primaryFunction;
    }

    public String getColorScreen() {
        return colorScreen;
    }

    public void setColorScreen(String colorScreen) {
        this.colorScreen = colorScreen;
    }

    public boolean isFmRadio() {
        return fmRadio;
    }

    public void setFmRadio(boolean fmRadio) {
        this.fmRadio = fmRadio;
    }
}
