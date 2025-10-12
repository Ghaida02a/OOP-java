public class FoldablePhone extends SmartPhone {
    private String foldingMechanism; //"Horizontal" or "Vertical".
    private int screenDurabilityFolds; //Number of folds the screen can withstand.
    private float outerDisplaySize; //Screen size in inches,

    public String getFoldingMechanism() {
        return foldingMechanism;
    }

    public void setFoldingMechanism(String foldingMechanism) {
        this.foldingMechanism = foldingMechanism;
    }

    public int getScreenDurabilityFolds() {
        return screenDurabilityFolds;
    }

    public void setScreenDurabilityFolds(int screenDurabilityFolds) {
        this.screenDurabilityFolds = screenDurabilityFolds;
    }

    public float getOuterDisplaySize() {
        return outerDisplaySize;
    }

    public void setOuterDisplaySize(float outerDisplaySize) {
        this.outerDisplaySize = outerDisplaySize;
    }
}
