package com.example.portfolio.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionnalExp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String company;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio2;
}
