package rs.edu.raf.nwp.repositories;

import org.springframework.data.repository.CrudRepository;
import rs.edu.raf.nwp.model.Group;

public interface GroupRepository extends CrudRepository<Group, Long> {
}
