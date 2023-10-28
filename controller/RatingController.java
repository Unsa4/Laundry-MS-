package com.example.laundry.controller;

import com.example.laundry.model.Rating;
import com.example.laundry.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RatingController {

    private final RatingService RatingService;

    @Autowired
    public RatingController(RatingService RatingService) {
        this.RatingService = RatingService;
    }

    @PostMapping("/Ratings")
    public ResponseEntity<Rating> createRating(@Valid @RequestBody Rating Rating) {
        Rating createdRating = RatingService.saveRating(Rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRating);
    }

    @GetMapping("/Ratings")
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> Ratings = RatingService.getAllRatings();
        return ResponseEntity.ok(Ratings);
    }

    @GetMapping("/Ratings/{id}")
    public ResponseEntity<Optional<Rating>> getRatingById(@PathVariable(value = "id") Long id) {
        Optional<Rating> Rating = RatingService.getRatingById(String.valueOf(id));
        if (Rating.isPresent()) {
            return ResponseEntity.ok(Rating);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/Ratings/{id}")
    public ResponseEntity<Rating> updateRating(@PathVariable(value = "id") Long id, @RequestBody Rating RatingDetails) {
        Rating updatedRating = RatingService.updateRating(String.valueOf(id), RatingDetails);
        return ResponseEntity.ok(updatedRating);
    }

    @DeleteMapping("/Ratings/{id}")
    public ResponseEntity<Void> deleteRating(@PathVariable(value = "id") Long id) {
        RatingService.deleteRating(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
