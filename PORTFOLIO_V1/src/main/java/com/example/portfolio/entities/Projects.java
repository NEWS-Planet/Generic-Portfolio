package com.example.portfolio.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProject;
    private String description;

    @ElementCollection
    private List<String> imagesLinks;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio3;
}
