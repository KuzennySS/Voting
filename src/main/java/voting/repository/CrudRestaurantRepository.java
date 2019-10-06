package voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import voting.model.Restaurant;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRestaurantRepository extends JpaRepository<Restaurant, Integer> {

/*    @Override
    @Transactional
    Restaurant save(Restaurant item);*/

/*//    @Query("SELECT m FROM Meal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
////    List<Restaurant> getAll(@Param("userId") int userId);
    List<Restaurant> getAll(); */

}
