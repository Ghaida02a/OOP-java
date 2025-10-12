public class Phone extends BaseEntity{

    private String name;
    private String brand;
    private double price;
    private String color;
    private Integer quantity;
    private Integer batteryLife; // in hours

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(Integer batteryLife) {
        this.batteryLife = batteryLife;
    }
}
