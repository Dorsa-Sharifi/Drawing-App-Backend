package com.example.paintapp.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")  // Avoids reserved SQL keyword "user"
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String displayName;

    
    @Column(unique = true)
    private String username;

    @Id
    private Long id;
}
