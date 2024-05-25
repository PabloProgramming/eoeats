package com.app.eoeats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

@Table(name = "amount")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Amount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    private int amount;
    private String description;
    @NonNull
    private double subTotalPrice;
    @NonNull
    private int type;
    @OneToMany(mappedBy = "amount")
    private List<AmountExtra> amountExtras;
    @ManyToOne
    private Plate plate;
    @ManyToOne
    private Order order;
}
