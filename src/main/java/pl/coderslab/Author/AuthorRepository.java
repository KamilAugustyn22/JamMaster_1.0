package pl.coderslab.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query(value = "INSERT :author INTO authors;", nativeQuery = true)
    void createAuthor(@Param("author")Author author);

    Author readAuthorById(long id);

    @Query("SELECT a FROM Author a")
    List<Author> findAllAuthors();

    @Query(value = "UPDATE authors SET name = :name WHERE id = :id;", nativeQuery = true)
    void updateAuthor(@Param("id")long id, @Param("name")String name);

    void deleteAuthorById(long id);
}
