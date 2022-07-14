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

    @Query("select s from SongSet s")
    List<SongSet> findAllSets();


    void deleteById(long id);
}
