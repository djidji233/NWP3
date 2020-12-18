package rs.edu.raf.nwp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_TYPE")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ime;

}
