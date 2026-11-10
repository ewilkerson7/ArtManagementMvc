package com.example.ArtManagementMvc.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PRINT")
public class Print extends Art {
    private String openEditionType; // canvas, paper, or photo[cite: 1]
    private String category; // history, portrait, genre, landscape, or still life[cite: 1]

    // Getters and Setters
    public String getOpenEditionType() { return openEditionType; }
    public void setOpenEditionType(String openEditionType) { this.openEditionType = openEditionType; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}