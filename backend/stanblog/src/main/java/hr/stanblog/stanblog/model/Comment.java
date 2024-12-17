package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;


}
