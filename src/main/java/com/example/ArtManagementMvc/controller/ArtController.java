package com.example.ArtManagementMvc.controller;
import com.example.ArtManagementMvc.dto.ArtForm;
import com.example.ArtManagementMvc.model.*;
import com.example.ArtManagementMvc.repository.ArtRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        Art existing = artRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid art ID: " + id));

        ArtForm form = new ArtForm();

        form.setId(existing.getId());
        form.setArtType(existing.getArtType());
        form.setTitle(existing.getTitle());
        form.setAuthorName(existing.getAuthorName());
        form.setYearCreated(existing.getYearCreated());
        form.setPrice(existing.getPrice());
        form.setDescription(existing.getDescription());

        if (existing instanceof Painting painting) {
            form.setHeightInches(painting.getHeightInches());
            form.setWidthInches(painting.getWidthInches());
            form.setStyle(painting.getStyle());
            form.setTechnique(painting.getTechnique());
            form.setCategory(painting.getCategory());
        } else if (existing instanceof Drawing drawing) {
            form.setStyle(drawing.getStyle());
            form.setTechnique(drawing.getTechnique());
            form.setCategory(drawing.getCategory());
        } else if (existing instanceof Print print) {
            form.setOpenEditionType(print.getOpenEditionType());
            form.setCategory(print.getCategory());
        }else if (existing instanceof Sculpture sculpture) {
            form.setMaterial(sculpture.getMaterial());
            form.setWeightOunces(sculpture.getWeightOunces());
        }

        model.addAttribute("art", form);
        return "inventoryDetail";
    }

    // CREATE: Show add form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        // Defaults to Painting to avoid abstract class instantiation
        model.addAttribute("art", new ArtForm());
        return "inventoryAdd";
    }

    // CREATE: Process add form
    @PostMapping("/add")
    public String addArt(@Valid @ModelAttribute("art") ArtForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "inventoryAdd";
        }

        String type = form.getArtType() != null ? form.getArtType() : "PAINTING";
        Art art;
        switch (type) {
            case "DRAWING" -> {
                Drawing drawing = new Drawing();
                drawing.setStyle(form.getStyle());
                drawing.setTechnique(form.getTechnique());
                drawing.setCategory(form.getCategory());
                art = drawing;
            }
            case "PRINT" -> {
                Print print = new Print();
                print.setOpenEditionType(form.getOpenEditionType());
                print.setCategory(form.getCategory());
                art = print;
            }
            case "SCULPTURE" -> {
                Sculpture sculpture = new Sculpture();
                sculpture.setMaterial(form.getMaterial());
                sculpture.setWeightOunces(form.getWeightOunces());
                art = sculpture;
            }
            default -> {
                Painting painting = new Painting();
                painting.setHeightInches(form.getHeightInches());
                painting.setWidthInches(form.getWidthInches());
                painting.setStyle(form.getStyle());
                painting.setTechnique(form.getTechnique());
                painting.setCategory(form.getCategory());
                art = painting;
            }
        }

        // Copy common Art fields
        art.setId("ART" + form.getId().substring(3));
        art.setArtType(type);
        art.setTitle(form.getTitle());
        art.setAuthorName(form.getAuthorName());
        art.setYearCreated(form.getYearCreated());
        art.setPrice(form.getPrice());
        art.setDescription(form.getDescription());

        artRepository.save(art);
        return "redirect:/inventory";
    }

    // UPDATE: Show edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Art existing = artRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid art ID: " + id));

        ArtForm form = new ArtForm();

        form.setId(existing.getId());
        form.setArtType(existing.getArtType());
        form.setTitle(existing.getTitle());
        form.setAuthorName(existing.getAuthorName());
        form.setYearCreated(existing.getYearCreated());
        form.setPrice(existing.getPrice());
        form.setDescription(existing.getDescription());

        if (existing instanceof Painting painting) {
            form.setHeightInches(painting.getHeightInches());
            form.setWidthInches(painting.getWidthInches());
            form.setStyle(painting.getStyle());
            form.setTechnique(painting.getTechnique());
            form.setCategory(painting.getCategory());
        } else if (existing instanceof Drawing drawing) {
            form.setStyle(drawing.getStyle());
            form.setTechnique(drawing.getTechnique());
            form.setCategory(drawing.getCategory());
        } else if (existing instanceof Print print) {
            form.setOpenEditionType(print.getOpenEditionType());
            form.setCategory(print.getCategory());
        }else if (existing instanceof Sculpture sculpture) {
            form.setMaterial(sculpture.getMaterial());
            form.setWeightOunces(sculpture.getWeightOunces());
        }

        model.addAttribute("art", form);
        return "inventoryEdit";
    }

    // UPDATE: Process edit form
    @PostMapping("/edit/{id}")
    public String editArt(@PathVariable String id, @Valid @ModelAttribute("art") ArtForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            form.setId(id);
            return "inventoryEdit";
        }

        Art existing = artRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid art ID: " + id));

        existing.setTitle(form.getTitle());
        existing.setAuthorName(form.getAuthorName());
        existing.setYearCreated(form.getYearCreated());
        existing.setPrice(form.getPrice());
        existing.setDescription(form.getDescription());

        if (existing instanceof Painting painting) {
            painting.setHeightInches(form.getHeightInches());
            painting.setWidthInches(form.getWidthInches());
            painting.setStyle(form.getStyle());
            painting.setTechnique(form.getTechnique());
            painting.setCategory(form.getCategory());
        } else if (existing instanceof Drawing drawing) {
            drawing.setStyle(form.getStyle());
            drawing.setTechnique(form.getTechnique());
            drawing.setCategory(form.getCategory());
        } else if (existing instanceof Print print) {
            print.setOpenEditionType(form.getOpenEditionType());
            print.setCategory(form.getCategory());
        }else if (existing instanceof Sculpture sculpture) {
            sculpture.setMaterial(form.getMaterial());
            sculpture.setWeightOunces(form.getWeightOunces());
        }

        artRepository.save(existing);
        return "redirect:/inventory";
    }

    // DELETE: Remove an art piece
    @GetMapping("/delete/{id}")
    public String deleteArt(@PathVariable String id) {
        artRepository.deleteById(id);
        return "redirect:/inventory";
    }
}