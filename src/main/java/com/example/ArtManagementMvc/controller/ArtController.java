package com.example.ArtManagementMvc.controller;
import com.example.ArtManagementMvc.model.Art;
import com.example.ArtManagementMvc.repository.ArtRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inventory")
public class ArtController {

    private final ArtRepository artRepository;

    public ArtController(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    @GetMapping
    public String viewInventory(Model model) {
        model.addAttribute("artPieces", artRepository.findAll());
        return "inventory"; // Resolves to inventory.html
    }
}