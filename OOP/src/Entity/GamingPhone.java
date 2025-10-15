package Entity;

public class GamingPhone extends Phone {
    private String gpu;
    private Integer screenRefreshRate;

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public Integer getScreenRefreshRate() {
        return screenRefreshRate;
    }

    public void setScreenRefreshRate(Integer screenRefreshRate) {
        this.screenRefreshRate = screenRefreshRate;
    }
}
