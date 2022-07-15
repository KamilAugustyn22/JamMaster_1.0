package pl.coderslab.song;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.author.Author;
import pl.coderslab.user.User;

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
    private String songKey;
    private String introChords;
    private String verseChords;
    private String reffChords;
    private String bridgeChords;
    @NotBlank
    private String songText;
    private int tempo;
    private String mtrm;
    @ManyToOne
    private User user;
    @Column(name = "created")
    private LocalDateTime createdOn;

    public String getAuthor(){
        return author.getName();
    }




    public String toString(){
        return String.format("Song: id = %s,  title = %s, author = %s", id, title , author);
    }
}
