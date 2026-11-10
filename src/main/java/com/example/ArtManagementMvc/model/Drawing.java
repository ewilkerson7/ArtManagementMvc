package com.example.ArtManagementMvc.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("DRAWING")
public class Drawing extends Art {
    private String style; // e.g., abstract, surrealism, impressionism[cite: 1]
    private String technique; // e.g., pastel, colored pencil, charcoal[cite: 1]
    private String category; // history, portrait, genre, landscape, or still life[cite: 1]

    // Getters and Setters
    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }

    public String getTechnique() { return technique; }
    public void setTechnique(String technique) { this.technique = technique; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
