package com.example.ArtManagementMvc.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class ArtForm {
    @Id
    @Column(length = 10, nullable = false, unique = true)
    @NotBlank(message = "Art Number is required")
    @Pattern(
            regexp = "^ART\\d{7}$",
            message = "Id must be 10 chars, starts with 'ART'."
    )
    private String id;

    @Column(name = "art_type", insertable = false, updatable = false)
    private String artType;

    @Positive(message = "Price cannot be zero.")
    private double price;

    @Min(value = 1, message = "Year Created cannot be zero.")
    private int yearCreated;

    @NotBlank(message = "Title is required")
    private String title;

    @Column(length = 500)
    @NotBlank(message = "Description is required")
    private String description;

    @NotBlank(message = "Author Name is required")
    private String authorName;

    private double heightInches;
    private double widthInches;
    private String style;
    private String technique;
    private String category;
    private String openEditionType; // canvas, paper, or photo[cite: 1]
    private String material; // e.g., stone, metal, ceramic, wood, glass[cite: 1]
    private double weightOunces; // = 0.01f; //[cite: 1]


    // Getters and Setters omitted for brevity

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

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

    public String getOpenEditionType() { return openEditionType; }
    public void setOpenEditionType(String openEditionType) { this.openEditionType = openEditionType; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public double getWeightOunces() { return weightOunces; }
    public void setWeightOunces(double weightOunces) { this.weightOunces = weightOunces; }

}
