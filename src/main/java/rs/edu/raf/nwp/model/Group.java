package rs.edu.raf.nwp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ime;

    @OneToMany(mappedBy = "grupa",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JsonIgnore
//    @ToString.Exclude
    private List<User> korisnici;
}
