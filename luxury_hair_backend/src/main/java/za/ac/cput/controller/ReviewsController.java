package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Reviews;
import za.ac.cput.services.ReviewsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/Reviews")
public class ReviewsController {
    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/create")
    public Reviews create(@RequestBody Reviews reviews) {
        return reviewsService.create(reviews);
    }

    @GetMapping("/read/{ReviewID}")
    public Reviews read(@PathVariable String ReviewID) {
        return reviewsService.read(ReviewID);
    }

    @PostMapping("/update")
    public Reviews update(@RequestBody Reviews reviews) {
        return reviewsService.update(reviews);
    }

    @GetMapping("/readall")
    public List<Reviews> readAll() {
        return reviewsService.getall();
    }
}