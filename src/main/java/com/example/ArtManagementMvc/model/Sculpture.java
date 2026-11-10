package com.example.ArtManagementMvc.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SCULPTURE")
public class Sculpture extends Art {
    private String material; // e.g., stone, metal, ceramic, wood, glass[cite: 1]
    private double weightOunces; //[cite: 1]

    // Getters and Setters
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public double getWeightOunces() { return weightOunces; }
    public void setWeightOunces(double weightOunces) { this.weightOunces = weightOunces; }
}