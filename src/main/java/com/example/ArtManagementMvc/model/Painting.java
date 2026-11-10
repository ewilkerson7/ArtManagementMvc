package com.example.ArtManagementMvc.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PAINTING")
public class Painting extends Art {
    private double heightInches;
    private double widthInches;
    private String style;
    private String technique;
    private String category;

    // Getters and Setters

    public double getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(double heightInches) {
        this.heightInches = heightInches;
    }

    public double getWidthInches() {
        return widthInches;
    }

    public void setWidthInches(double widthInches) {
        this.widthInches = widthInches;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}