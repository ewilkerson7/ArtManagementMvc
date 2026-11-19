package com.example.ArtManagementMvc.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "art_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Art {
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

    @Override
    public String toString() {
        return super.toString();
    }
}