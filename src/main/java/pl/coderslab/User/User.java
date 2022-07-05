package pl.coderslab.User;


import lombok.Getter;
import lombok.Setter;
import pl.coderslab.Song.Song;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

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
    @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
}