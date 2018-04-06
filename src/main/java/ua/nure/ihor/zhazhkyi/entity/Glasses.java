package ua.nure.ihor.zhazhkyi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Glasses {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;


    @Column(name = "type", nullable = false)
    private String type;


    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "material")
    private String material;

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
        Glasses glasses = (Glasses) o;
        return id == glasses.id &&
                price == glasses.price &&
                Objects.equals(name, glasses.name) &&
                Objects.equals(type, glasses.type) &&
                Objects.equals(material, glasses.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, price, material);
    }
}
