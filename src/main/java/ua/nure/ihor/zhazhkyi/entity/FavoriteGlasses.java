package ua.nure.ihor.zhazhkyi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class FavoriteGlasses {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "glasses_id", nullable = false)
    private long glassesId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGlassesId() {
        return glassesId;
    }

    public void setGlassesId(long glassesId) {
        this.glassesId = glassesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FavoriteGlasses that = (FavoriteGlasses) o;
        return id == that.id &&
                userId == that.userId &&
                glassesId == that.glassesId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, glassesId);
    }
}
