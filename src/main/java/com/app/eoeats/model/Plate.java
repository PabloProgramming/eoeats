package com.app.eoeats.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
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
    private List<Allergen> allergens;
    @OneToMany(mappedBy = "plate")
    private List<Extra> extras;
    @OneToMany(mappedBy = "plate")
    private List<Amount> amounts;



}
