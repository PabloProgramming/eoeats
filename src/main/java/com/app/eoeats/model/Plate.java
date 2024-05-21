package com.app.eoeats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

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


}
