package pl.coderslab.Author;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.Song.Song;

import javax.persistence.*;


@Entity
@Setter
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
