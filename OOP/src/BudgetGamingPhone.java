public class BudgetGamingPhone extends GamingPhone {
    private float processorClockSpeed;
    private int ramSize; //GB
    private boolean gameBoosterSoftware;

    public float getProcessorClockSpeed() {
        return processorClockSpeed;
    }

    public void setProcessorClockSpeed(float processorClockSpeed) {
        this.processorClockSpeed = processorClockSpeed;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public boolean isGameBoosterSoftware() {
        return gameBoosterSoftware;
    }

    public void setGameBoosterSoftware(boolean gameBoosterSoftware) {
        this.gameBoosterSoftware = gameBoosterSoftware;
    }
}
