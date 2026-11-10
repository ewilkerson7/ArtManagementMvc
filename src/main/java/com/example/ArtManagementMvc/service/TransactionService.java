package com.example.ArtManagementMvc.service;
import com.example.ArtManagementMvc.exception.*;
import com.example.ArtManagementMvc.model.*;
import com.example.ArtManagementMvc.repository.*;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepo;
    private final ArtRepository artRepo;

    public TransactionService(TransactionRepository transactionRepo, ArtRepository artRepo) {
        this.transactionRepo = transactionRepo;
        this.artRepo = artRepo;
    }

    public double calculateTransactionPrice(Transaction transaction) {
        double total = 0.0;
        for (Art art : transaction.getArtPieces()) {
            total += art.getPrice();
            total += 10.99; // Basic shipping cost per piece[cite: 1]

            if (art instanceof Sculpture) {
                total += ((Sculpture) art).getWeightOunces() * 0.20; // Sculpture additional cost[cite: 1]
            } else if (art instanceof Painting) {
                Painting p = (Painting) art;
                double area = p.getHeightInches() * p.getWidthInches();
                if (area < 100) {
                    total += 5.99; // Less than 100 sq inches[cite: 1]
                } else if (area <= 300) {
                    total += 10.99; // Between 100 and 300 sq inches[cite: 1]
                } else {
                    total += 15.99; // Above 300 sq inches[cite: 1]
                }
            }
        }
        return total;
    }

    public Transaction completeTransaction(String transactionId) {
        Transaction t = transactionRepo.findById(transactionId)
                .orElseThrow(() -> new InvalidTransOperationException("Transaction not found on complete"));

        if (t.getTransactionDate() != null) {
            throw new InvalidTransactionException("Transaction is already completed.");
        }

        // Verify all art pieces are still available
        for (Art art : t.getArtPieces()) {
            if (!artRepo.existsById(art.getId())) {
                throw new InvalidTransactionException("Art work " + art.getId() + " is no longer in available list.");//[cite: 1]
            }
        }

        t.setTransactionPrice(calculateTransactionPrice(t));
        t.setTransactionDate(LocalDate.now()); // Sets date and signifies completion[cite: 1]

        // Remove art from inventory upon completion
        artRepo.deleteAll(t.getArtPieces()); //[cite: 1]

        return transactionRepo.save(t);
    }
}