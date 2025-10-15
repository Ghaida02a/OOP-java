package Entity;

public class BudgetGamingPhone extends GamingPhone {
    private float processorClockSpeed;
    private int ramSize; //GB
    private String gameBoosterSoftware;

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

    public String getGameBoosterSoftware() {
        return gameBoosterSoftware;
    }

    public void setGameBoosterSoftware(String gameBoosterSoftware) {
        this.gameBoosterSoftware = gameBoosterSoftware;
    }
}
