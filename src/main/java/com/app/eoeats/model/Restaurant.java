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
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String email;
    private String imageId;
    private String image;
    @NonNull
    private String name;
    @NonNull
    private String phone;
    @NonNull
    private String latitude;
    @NonNull
    private String longitude;
    @OneToMany(mappedBy = "restaurant")
    private List<User> users;
    @OneToOne
    @JoinColumn(name = "restaurantConfigId")
    private RestaurantConfiguration restaurantConfiguration;
    @OneToMany(mappedBy = "restaurant")
    private List<Category> categories;
    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders;



}
