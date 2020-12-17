package rs.edu.raf.nwp.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.edu.raf.nwp.model.Group;
import rs.edu.raf.nwp.model.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
}
