package com.app.eoeats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

@Table(name = "orderRest")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    private String date;
    @NonNull
    private boolean isPrinted;
    @NonNull
    private int tableNumber;
    @NonNull
    private double totalPrice;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Amount> amounts;
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;
}
