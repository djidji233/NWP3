package rs.edu.raf.nwp.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(nullable = false)
    private String ime;

    @Column(nullable = false)
    private String prezime;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(nullable = false)
    private UserType tip;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    private Group grupa;

}
