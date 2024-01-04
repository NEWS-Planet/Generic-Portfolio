package com.example.portfolio.entities;

import com.example.portfolio.entities.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "headline_id")  // Correction ici : Utilisez un nom de colonne différent pour la clé étrangère
    private Headline headline;

    @OneToMany(mappedBy = "portfolio1", cascade = CascadeType.ALL)
    private List<Education> educationList;

    @OneToMany(mappedBy = "portfolio2", cascade = CascadeType.ALL)
    private List<ProfessionnalExp> professionnalExpList;

    @OneToMany(mappedBy = "portfolio3", cascade = CascadeType.ALL)
    private List<Projects> projectsList;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "portfolio_skills",
            joinColumns = @JoinColumn(name = "portfolio_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id")
    )
    private List<Skills> skillsList;
}
