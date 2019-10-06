package voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"id", "restaurant_name"}, name = "restaurants_unique_id_restaurant_name_idx")})
public class Restaurant extends AbstractBaseEntity {

    @Column(name = "restaurant_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String restaurantName;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public Restaurant() {
    }

    public Restaurant(@NotBlank @Size(min = 2, max = 50) String restaurantName) {
        this(null, restaurantName);
    }

    public Restaurant(Integer id, @NotBlank @Size(min = 2, max = 50) String restaurantName) {
        super(id);
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantName='" + restaurantName + '\'' +
                ", id=" + id +
                '}';
    }
}
