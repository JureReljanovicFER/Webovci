package hr.stanblog.stanblog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Discussion {
    @Id
     Long id;
}