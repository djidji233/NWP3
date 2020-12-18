package rs.edu.raf.nwp.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rs.edu.raf.nwp.model.Group;
import rs.edu.raf.nwp.model.User;
import rs.edu.raf.nwp.model.UserType;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.ime LIKE CONCAT('%',:ime,'%') AND u.prezime LIKE CONCAT('%',:prezime,'%') AND u.tip.ime LIKE CONCAT('%',:tip,'%') AND u.grupa.ime LIKE CONCAT('%',:grupa,'%')")
    List<User> searchUsers(@Param("ime") String ime, @Param("prezime") String prezime, @Param("tip") String tip, @Param("grupa") String grupa);
}
