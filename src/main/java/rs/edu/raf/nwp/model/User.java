package rs.edu.raf.nwp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @OneToOne(cascade = CascadeType.MERGE)
    //@Column(nullable = false)
    private UserType tip;

    @ManyToOne//(fetch = FetchType.EAGER) //(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    @JsonIgnoreProperties("korisnici")
    private Group grupa;

}
