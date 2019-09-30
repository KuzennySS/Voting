package voting.model;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "voting", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "voting_date"}, name = "voting_idx")})
public class Voting extends AbstractBaseEntity  {

    @Column(name = "user_id", nullable = false)
    @NotNull
    private Integer userId;

    @Column(name = "voting_date", nullable = false)
    @NotNull
//    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private LocalDate votingDate;

    @Column(name = "restaurantId", nullable = false)
    @NotNull
    private Integer restaurantId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public LocalDate getVotingDate() {
        return votingDate;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setVotingDate(LocalDate votingDate) {
        this.votingDate = votingDate;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Voting() {
    }

    public Voting(@NotNull Integer userId, @NotNull LocalDate votingDate, @NotNull Integer restaurantId) {
        this.userId = userId;
        this.votingDate = votingDate;
        this.restaurantId = restaurantId;
    }
}
