package com.app.movie.service.impl;

import com.app.movie.exception.BadRequestException;
import com.app.movie.helper.CommonHelper;
import com.app.movie.model.base.Constant;
import com.app.movie.model.movie.MovieInfoResponse;
import com.app.movie.model.movie.OscarWonList;
import com.app.movie.model.movie.MovieRatings;
import com.app.movie.model.user.User;
import com.app.movie.payload.ApiResponse;
import com.app.movie.repository.MovieRepository;
import com.app.movie.repository.RatingRepository;
import com.app.movie.repository.UserRepository;
import com.app.movie.security.UserPrincipal;
import com.app.movie.service.MovieService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private static final String NOT_WIN_OSCAR = " didn't win an Oscar";
    private static final String WON_OSCAR = "  won an Oscar";
    private static final String NOT_ACCEPTED_RATE = "you already rated the ";


    OscarWonList movieList;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    CommonHelper commonHelper;

    @Override
    public ResponseEntity<ApiResponse> getOscarWonInfo (String nominee) throws IOException {

        checkMovieExist(nominee);

        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE, nominee + NOT_WIN_OSCAR);

        movieList = movieRepository.findByNominee(nominee)
                .orElseThrow(() -> new BadRequestException(apiResponse));
        if(movieList ==null) return ResponseEntity.ok().body(new ApiResponse(Boolean.TRUE, nominee + NOT_WIN_OSCAR));

        return ResponseEntity.ok().body(new ApiResponse(Boolean.TRUE, nominee + WON_OSCAR));

    }

    @Override
    public ResponseEntity<HttpStatus> addRating(MovieRatings movieRatings, UserPrincipal currentUser) throws IOException {

        checkMovieExist(movieRatings.getMovieTitle());
        User user = userRepository.getUser(currentUser);

        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, NOT_ACCEPTED_RATE +  movieRatings.getMovieTitle());
        ratingRepository.findByUserIdAndMovieTitle(user.getId(), movieRatings.getMovieTitle())
                .ifPresent(s -> {
                    throw new BadRequestException(apiResponse);
                });

        movieRatings.setUser(user);
        movieRatings.setMovieTitle(movieRatings.getMovieTitle().toUpperCase());

        ratingRepository.save(movieRatings);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public List<String> getTopRated() throws IOException {

        List<MovieInfoResponse> movieInfoResponse = new ArrayList<MovieInfoResponse>();

        var top10MovieList =ratingRepository.findTop10Ratings().stream().limit(10).collect(Collectors.toList());

        for (String item : top10MovieList) {
            movieInfoResponse.add(
                    commonHelper.callGetService(Constant.EndPoint_OMDB, Constant.Api_Key_OMDB, "t="+item, MovieInfoResponse.class)
            );
        }

        nullCheckAndFormatBoxOffice(movieInfoResponse);

        movieInfoResponse.sort(Comparator.comparing(MovieInfoResponse::getBoxOffice).reversed());

        return movieInfoResponse.stream().map(MovieInfoResponse::getTitle).collect(Collectors.toList());
    }

    public void checkMovieExist(String movieTitle) throws IOException {

        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Film does not exist");

        String parameterValue = "t=" + movieTitle;

        if (commonHelper.callGetService
                        (Constant.EndPoint_OMDB, Constant.Api_Key_OMDB, parameterValue, MovieInfoResponse.class)
                .getResponse().equals("False")) {
            throw new BadRequestException(apiResponse);

        }
    }
    public void nullCheckAndFormatBoxOffice(List<MovieInfoResponse> movieInfoResponse) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        movieInfoResponse.forEach(m -> {
            try {
                if (m.getBoxOffice().equals("N/A")) m.setBoxOffice("0");
                else m.setBoxOffice(format.parse(m.getBoxOffice()).toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
}

