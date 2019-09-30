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
@Table(name = "menu", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "dish_name"}, name = "menu_unique_idx")})
public class Menu extends AbstractBaseEntity {

    @Column(name = "restaurant_id", nullable = false)
    @NotNull
    private Integer restaurantId;

    @Column(name = "dish_name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String dishName;

    @Column(name = "price", nullable = false)
    @NotNull
    private Float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public String getDishName() {
        return dishName;
    }

    public Float getPrice() {
        return price;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Menu(@NotNull Integer restaurantId, @NotBlank @Size(min = 2, max = 50) String dishName, @NotNull Float price) {
        this.restaurantId = restaurantId;
        this.dishName = dishName;
        this.price = price;
    }
}
