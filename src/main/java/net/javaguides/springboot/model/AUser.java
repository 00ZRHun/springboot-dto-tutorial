package net.javaguides.springboot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class AUser {
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
    private BLocation location;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private COccupationCategory occupation;

    @Column(name = "created")
    @JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
    private LocalDateTime created = LocalDateTime.now();

    @Column(name = "updated")
    @JsonFormat(pattern="dd-MMM-yyyy HH:mm:ss")
    private LocalDateTime updated;
}
