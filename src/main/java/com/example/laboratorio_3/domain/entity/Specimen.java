package com.example.laboratorio_3.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "specimen")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specimen {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "dangerLevel", nullable = false)
    private Integer dangerLevel;

    @Column(name = "isFriendly", nullable = false)
    private Boolean isFriendly;
}

