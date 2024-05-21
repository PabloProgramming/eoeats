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
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private int amount;
    private String description;
    @NonNull
    private double subTotalPrice;
    @NonNull
    private int type;
}
