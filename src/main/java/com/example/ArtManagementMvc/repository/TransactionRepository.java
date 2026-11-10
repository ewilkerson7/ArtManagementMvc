package com.example.ArtManagementMvc.repository;
import com.example.ArtManagementMvc.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByCustomerEmail(String email);
    List<Transaction> findByTransactionDate(LocalDate date);
    List<Transaction> findByArtPieces_Id(String artId);
}
