package Entity;

public class CameraPhone extends SmartPhone {
    private float mainSensorMegapixels; //Camera resolutions
    private float opticalZoomLevel;
    private String proModeFeatures; //shutter speed, white balance

    public float getMainSensorMegapixels() {
        return mainSensorMegapixels;
    }

    public void setMainSensorMegapixels(float mainSensorMegapixels) {
        this.mainSensorMegapixels = mainSensorMegapixels;
    }

    public float getOpticalZoomLevel() {
        return opticalZoomLevel;
    }

    public void setOpticalZoomLevel(float opticalZoomLevel) {
        this.opticalZoomLevel = opticalZoomLevel;
    }

    public String getProModeFeatures() {
        return proModeFeatures;
    }

    public void setProModeFeatures(String proModeFeatures) {
        this.proModeFeatures = proModeFeatures;
    }
}
