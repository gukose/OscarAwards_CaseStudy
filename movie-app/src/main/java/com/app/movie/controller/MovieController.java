package com.app.movie.controller;

import com.app.movie.model.movie.OscarWonList;
import com.app.movie.model.movie.MovieRatings;
import com.app.movie.payload.ApiResponse;
import com.app.movie.security.CurrentUser;
import com.app.movie.security.UserPrincipal;
import com.app.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{nominee}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> getOscarWonInfo(@PathVariable(name = "nominee") String nominee) throws IOException {
        return movieService.getOscarWonInfo(nominee);
    }

    @PostMapping("/rate")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<HttpStatus> addRating(@Valid @RequestBody MovieRatings movieRatings,
                                                @CurrentUser UserPrincipal currentUser) throws IOException {
        return movieService.addRating(movieRatings,currentUser);
    }

    @GetMapping("/rate/top")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<String> getTopRated() throws IOException {
        return movieService.getTopRated();
    }
}
