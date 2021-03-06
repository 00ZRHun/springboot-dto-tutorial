package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String password;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id")
    private Location location;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private OccupationModel occupation;
}
