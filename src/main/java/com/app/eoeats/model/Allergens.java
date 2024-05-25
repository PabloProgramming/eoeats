package com.app.eoeats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allergens {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;
@NonNull
@Column (unique = true)
private String name;
@ManyToMany(mappedBy = "allergens")
private List<Plate> plates;


}
