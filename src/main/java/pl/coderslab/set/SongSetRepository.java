package pl.coderslab.set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongSetRepository extends JpaRepository<SongSet, Long> {
    @Query(value = "INSERT :song_set INTO song_set;", nativeQuery = true)
    void createSet(@Param("song_set") SongSet songSet);

    SongSet readSongSetById(long id);

    @Query("select s from SongSet s")
    List<SongSet> findAllSets();

//    @Query(value = "UPDATE song_set SET name = :name WHERE id = :id;", nativeQuery = true)
//    void updateSet(@Param("id")long id, @Param("name")String name);

    void deleteById(long id);
}
