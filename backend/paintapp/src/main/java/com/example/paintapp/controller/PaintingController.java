package com.example.paintapp.controller;

import com.example.paintapp.model.Painting;
import com.example.paintapp.model.User;
import com.example.paintapp.repository.PaintingRepository;
import com.example.paintapp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/paintings")
@CrossOrigin
public class PaintingController {
    private final PaintingRepository paintingRepository;
    private final UserRepository userRepository;

    public PaintingController(PaintingRepository paintingRepository, UserRepository userRepository) {
        this.paintingRepository = paintingRepository;
        this.userRepository = userRepository;
    }

    @PostMapping
    public Painting savePainting(@RequestBody PaintingRequest request) {
        User user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Deleting old painting if any
        paintingRepository.findByUser(user).ifPresent(paintingRepository::delete);

        Painting painting = new Painting();
        painting.setTitle(request.title());
        painting.setShapesData(request.shapesData());
        painting.setUser(user);
        painting.setCreatedAt(LocalDateTime.now());

        return paintingRepository.save(painting);
    }

    @GetMapping("/{userId}")
    public List<Painting> getPaintingsByUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return paintingRepository.findByUser(user)
                .map(List::of)
                .orElse(List.of());
    }

    @GetMapping("/by-id/{paintingId}")
    public Painting getPaintingById(@PathVariable Long paintingId) {
        return paintingRepository.findById(paintingId)
                .orElseThrow(() -> new RuntimeException("Painting not found"));
    }

    public record PaintingRequest(Long userId, String title, String shapesData) {}
}
