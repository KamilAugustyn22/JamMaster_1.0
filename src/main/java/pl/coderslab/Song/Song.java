package pl.coderslab.Song;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import pl.coderslab.Author.Author;
import pl.coderslab.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @ManyToOne
    private Author author;
    private String key;
    private String introChords;
    private String verseChords;
    private String reffChords;
    private String bridgeChords;
    private String text;
    private int tempo;
    private String mtrm;
    @ManyToOne
    private User user;
    @Column(name = "created")
    private LocalDateTime createdOn;
}
