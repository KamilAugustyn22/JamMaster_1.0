package pl.coderslab.user;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.role.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String username;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    @Range(min = 6, max = 16)
    private String password;

    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}