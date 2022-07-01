package pl.coderslab.User;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
@Table(name = "users")
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
    @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
}
