package pl.coderslab.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "INSERT INTO user(name, surname, email, username, password) VALUES (:name, :surname, :email, :username, :password);", nativeQuery = true)
    @Modifying
    @Transactional
    void createUser(@Param("name")String name, @Param("surname")String surname, @Param("email")String email, @Param("username")String username, @Param("password")String password);

    User readUserById(long id);

    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query(value = "UPDATE user SET username = :username, name = :name, surname = :surname" +
            "email = :email, password = :password WHERE id = :id", nativeQuery = true)
    void updateUser(@Param("id")long id,@Param("username")String username, @Param("name")String name,
                    @Param("surname")String surname, @Param("email")String email, @Param("password")String password);

    void deleteUserById(long id);

    User findByUsername(String username);
}
