package ua.nure.ihor.zhazhkyi.dto.glasses;

import java.util.Objects;

public class GlassesDto {

    private String name;

    private String type;

    private int price;

    private String color;

    public GlassesDto() {
    }

    public GlassesDto(String name, String type, int price, String color) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GlassesDto that = (GlassesDto) o;
        return price == that.price &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price, color);
    }
}
