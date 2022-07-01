package pl.coderslab.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "INSERT :user INTO users; ", nativeQuery = true)
    void createUser(@Param("user")User user);

    User readUserById(long id);

    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query(value = "UPDATE users SET username = :username, name = :name, surname = :surname" +
            "email = :email, password = :password WHERE id = :id", nativeQuery = true)
    void updateUser(@Param("id")long id,@Param("username")String username, @Param("name")String name,
                    @Param("surname")String surname, @Param("email")String email, @Param("password")String password);

    void deleteUserById(long id);
}
