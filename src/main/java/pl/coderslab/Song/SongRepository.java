package pl.coderslab.Song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    @Query(value = "INSERT :song INTO song; ", nativeQuery = true)
    void createSong(@Param("song")Song song);

    Song readSongById(long id);

    @Query("SELECT s from Song s")
    List<Song> findAllSongs();
}
