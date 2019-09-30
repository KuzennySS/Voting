package voting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "result", uniqueConstraints = {@UniqueConstraint(columnNames = {"restaurant_id", "count_vote"}, name = "result_idx")})
public class Result extends AbstractBaseEntity {

    @Column(name = "restaurant_id", nullable = false)
    @NotNull
    private Integer restaurantId;

    @Column(name = "count_vote", nullable = false)
    @NotNull
    private Integer countVote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public Integer getCountVote() {
        return countVote;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setCountVote(Integer countVote) {
        this.countVote = countVote;
    }

    public Result() {
    }

    public Result(@NotNull Integer restaurantId, @NotNull Integer countVote) {
        this.restaurantId = restaurantId;
        this.countVote = countVote;
    }
}
