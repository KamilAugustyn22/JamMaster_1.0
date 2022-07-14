package pl.coderslab.set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.user.User;

import java.util.List;

@Repository
public interface SongSetRepository extends JpaRepository<SongSet, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO song_set(user_id, name) VALUES (:user, :name);", nativeQuery = true)
    void createSet(@Param("user") User user, @Param("name")String name);

    SongSet readSongSetById(long id);

    @Query("select s from SongSet s where s.user.id = :id")
    List<SongSet> findAllSets(@Param("id")long id);

    @Query("select count(s) from SongSet s WHERE s.user.id = :id")
    Integer countAllByUser(@Param("id")long id);

    void deleteById(long id);

    @Modifying
    @Transactional
    @Query(value = "insert into song_set_song_list(song_set_id, song_list_id) values (:setId, :songId);", nativeQuery = true)
    void addSongToSet(@Param("setId") long setId,@Param("songId") long songId);

    @Modifying
    @Transactional
    @Query(value = "delete from song_set_song_list WHERE song_set_id = :setId AND song_list_id = :songId" , nativeQuery = true)
    void deleteSongFromSet(@Param("setId")long setId, @Param("songId")long songId);
}
