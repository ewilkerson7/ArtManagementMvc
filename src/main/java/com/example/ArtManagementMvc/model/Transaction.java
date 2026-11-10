package com.example.ArtManagementMvc.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Transaction {
    @Id
    private String transactionId;

    @Embedded
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "transaction_arts",
            joinColumns = @JoinColumn(name = "transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "art_id")
    )
    private List<Art> artPieces;

    private LocalDate transactionDate; // Null means incomplete
    private Double transactionPrice;

    // Getters and Setters

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Art> getArtPieces() {
        return artPieces;
    }

    public void setArtPieces(List<Art> artPieces) {
        this.artPieces = artPieces;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(Double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
