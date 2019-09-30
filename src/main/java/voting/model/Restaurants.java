package voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "restaurant_name"}, name = "pk_restaurants")})
public class Restaurants extends AbstractBaseEntity {

    @Column(name = "restaurant_id", nullable = false)
    @NotNull
    private Integer restaurantId;

    @Column(name = "restaurant_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String restaurantName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Restaurants() {
    }

    public Restaurants(@NotNull Integer restaurantId, @NotBlank @Size(min = 2, max = 50) String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }
}
