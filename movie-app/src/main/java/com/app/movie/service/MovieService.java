package com.app.movie.service;

import com.app.movie.model.movie.OscarWonList;
import com.app.movie.model.movie.MovieRatings;
import com.app.movie.payload.ApiResponse;
import com.app.movie.security.CurrentUser;
import com.app.movie.security.UserPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface MovieService {
    ResponseEntity<ApiResponse> getOscarWonInfo(String nominee) throws IOException;
    ResponseEntity<HttpStatus> addRating (MovieRatings movieRatings, @CurrentUser UserPrincipal currentUser) throws IOException;
    List<String> getTopRated() throws IOException;
}
