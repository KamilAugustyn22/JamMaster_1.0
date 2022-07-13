package pl.coderslab.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.song.Song;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "INSERT INTO author(name)VALUES (:name);", nativeQuery = true)
    void createAuthor(@Param("name")String name);

    Author readAuthorById(long id);

    @Query("SELECT a FROM Author a")
    List<Author> findAllAuthors();

    @Query(value = "UPDATE author SET name = :name WHERE id = :id;", nativeQuery = true)
    void updateAuthor(@Param("id")long id, @Param("name")String name);

    void deleteAuthorById(long id);

    @Query(value = "select s from Song s Where s.author = :authorId")
    List<Song> findAllSongsByAuthor(@Param("authorId") long authorId);
    @Query(value = "select count(*) from song where author_id = :authorId;", nativeQuery = true)
    Integer countAllSongsByAuthor(@Param("authorId") long authorId);
    @Query("select count(a) from Author a")
    Integer countAuthors();
    @Query(value = "SELECT a from Author a where a.name = :name")
    Author findAuthorByName(@Param("name") String name);


}
