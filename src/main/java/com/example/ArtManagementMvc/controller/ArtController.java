package com.example.ArtManagementMvc.controller;
import com.example.ArtManagementMvc.model.Art;
import com.example.ArtManagementMvc.model.Painting;
import com.example.ArtManagementMvc.repository.ArtRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventory")
public class ArtController {

    private final ArtRepository artRepository;

    public ArtController(ArtRepository artRepository) {
        this.artRepository = artRepository;
    }

    // READ: View all inventory
    @GetMapping
    public String viewInventory(Model model) {
        model.addAttribute("artPieces", artRepository.findAll());
        return "inventory";
    }

    // READ: View details of a specific art piece
    @GetMapping("/{id}")
    public String viewArtDetail(@PathVariable String id, Model model) {
        Art art = artRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid art ID: " + id));
        model.addAttribute("art", art);
        return "inventoryDetail";
    }

    // CREATE: Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        // Defaults to Painting to avoid abstract class instantiation
        model.addAttribute("art", new Painting());
        return "inventoryAdd";
    }

    // CREATE: Process add form
    @PostMapping("/add")
    public String addArt(@ModelAttribute Painting art) {
        artRepository.save(art);
        return "redirect:/inventory";
    }

    // UPDATE: Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Art art = artRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid art ID: " + id));
        model.addAttribute("art", art);
        return "inventoryEdit";
    }

    // UPDATE: Process edit form
    @PostMapping("/edit/{id}")
    public String editArt(@PathVariable String id, @ModelAttribute Painting art) {
        art.setId(id); // Ensure the ID remains the same
        artRepository.save(art);
        return "redirect:/inventory";
    }

    // DELETE: Remove an art piece
    @GetMapping("/delete/{id}")
    public String deleteArt(@PathVariable String id) {
        artRepository.deleteById(id);
        return "redirect:/inventory";
    }
}