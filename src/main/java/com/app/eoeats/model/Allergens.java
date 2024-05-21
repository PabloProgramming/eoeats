package com.app.eoeats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Allergens {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
@NonNull
@Column (unique = true)
private String name;


}
