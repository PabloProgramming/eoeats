package com.app.eoeats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private int type;
    @NonNull
    private String name;
    private String description;
    @NonNull
    private double price;
    @NonNull
    private boolean isAvailable;
    @NonNull
    private boolean isKitchenPrinter;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Allergens> allergens;
    @OneToMany(mappedBy = "plate")
    private List<Extras> extras;
    @OneToMany(mappedBy = "plate")
    private List<Amount> amounts;



}
