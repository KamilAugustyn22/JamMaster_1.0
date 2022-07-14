package pl.coderslab.set;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.song.Song;
import pl.coderslab.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Setter
@Getter
public class SongSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;

    @NotBlank
    private String name;

    @OneToMany
    List<Song> songList;

}
