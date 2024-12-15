package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

@Entity
@Table
public class UserDiscussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
}
