package rs.edu.raf.nwp.repositories;

import org.springframework.stereotype.Repository;
import rs.edu.raf.nwp.model.Group;
import rs.edu.raf.nwp.model.User;
import rs.edu.raf.nwp.model.UserType;

import java.util.List;

@Repository
public interface CustomUserRepository {
    List<User> searchUsers (String ime, String prezime, UserType tip, Group grupa);
}
