package com.app.eoeats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String imageId;
    private String image;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Plate> plates;
    @ManyToOne
    private Restaurant restaurant;

}
