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


    @Column(name="lens_height", nullable = false)
    private int lensHeight;

    @Column(name="lens_width", nullable = false)
    private int lensWidth;

    @Column(name="bridge_width", nullable = false)
    private int bridgeWidth;

    @Column(name = "color")
    private String color;

    @Column(name = "path")
    private String path;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLensHeight() {
        return lensHeight;
    }

    public void setLensHeight(int lensHeight) {
        this.lensHeight = lensHeight;
    }

    public int getLensWidth() {
        return lensWidth;
    }

    public void setLensWidth(int lensWidth) {
        this.lensWidth = lensWidth;
    }

    public int getBridgeWidth() {
        return bridgeWidth;
    }

    public void setBridgeWidth(int bridgeWidth) {
        this.bridgeWidth = bridgeWidth;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
                Objects.equals(name, glasses.name) &&
                Objects.equals(type, glasses.type) &&
                Objects.equals(color, glasses.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, color);
    }
}
