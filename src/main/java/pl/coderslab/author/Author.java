package pl.coderslab.author;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.*;


@Entity
@Setter
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


}
