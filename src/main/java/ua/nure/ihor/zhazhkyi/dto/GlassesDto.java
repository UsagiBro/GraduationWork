package ua.nure.ihor.zhazhkyi.dto;

import java.util.Objects;

public class GlassesDto {

    private String name;

    private String type;

    private int price;

    private String material;

    public GlassesDto() {
    }

    public GlassesDto(String name, String type, int price, String material) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.material = material;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
                Objects.equals(material, that.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, price, material);
    }
}
