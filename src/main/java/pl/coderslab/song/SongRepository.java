package pl.coderslab.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.author.Author;
import pl.coderslab.user.User;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO song(title, author_id, tempo, mtrm, song_key, intro_chords, verse_chords, " +
            "reff_chords, bridge_chords, song_text, user_id, created) VALUES (:title, :author, :tempo, :mtrm, :songKey, :introChords," +
            ":verseChords, :reffChords, :bridgeChords, :songText, :user, :created); ", nativeQuery = true)
    void createSong(@Param("title")String title, @Param("author")Author author, @Param("tempo")int Tempo,
                    @Param("mtrm")String mtrm, @Param("songKey")String songKey, @Param("introChords")String introChords,
                    @Param("verseChords")String verseChords, @Param("reffChords")String reffChords,
                    @Param("bridgeChords")String bridgeChords, @Param("songText")String songText, @Param("user")User user, @Param("created")LocalDateTime created);

    Song readSongById(long id);

    @Query("SELECT s from Song s")
    List<Song> findAllSongs();

    @Query("SELECT s from Song s where s.author.id = :id")
    List<Song>findAllByAuthor(@Param("id") long id);

    Song countAllByAuthor(long author_id);

    @Query("select count(s) from Song s ")
    Integer countAllSongs();
    @Query(value = "SELECT * FROM song ORDER BY ID desc LIMIT 1", nativeQuery = true)
    Song findLastSong();
    @Query("select s from Song s where s.id = :id")
    Song findSongById(@Param("id") long id);
}
