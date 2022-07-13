package com.app.movie.repository;

import com.app.movie.model.movie.OscarWonList;
import com.app.movie.model.movie.MovieRatings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<MovieRatings, Long> {
    Optional<MovieRatings> findByUserIdAndMovieTitle(Long userId, String movieTitle);

    @Query(value = "SELECT m.movieTitle FROM MovieRatings AS m GROUP BY m.movieTitle ORDER BY SUM(m.ratings) DESC")
    List<String> findTop10Ratings();
}
