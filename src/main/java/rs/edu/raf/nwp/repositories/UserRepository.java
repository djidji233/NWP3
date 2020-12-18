package rs.edu.raf.nwp.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.edu.raf.nwp.model.Group;
import rs.edu.raf.nwp.model.User;
import rs.edu.raf.nwp.model.UserType;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>, CustomUserRepository {

}
