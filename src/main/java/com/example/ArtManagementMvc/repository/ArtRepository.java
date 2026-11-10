package com.example.ArtManagementMvc.repository;
import com.example.ArtManagementMvc.model.Art;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtRepository extends JpaRepository<Art, String> {
}
