package com.springmoon.movies.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.allMovies();
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        Optional<Movie> targetMovie = movieService.singleMovie(imdbId);
        return new ResponseEntity<Optional<Movie>>(targetMovie, HttpStatus.OK);
    }

    @GetMapping("/jsp/{imdbId}")
    public ModelAndView jspSingleMovie(@PathVariable String imdbId) {
        Optional<Movie> targetMovie = movieService.singleMovie(imdbId);
        if (!!targetMovie.isEmpty()) {
            return new ModelAndView("noSingleMovie");
        } else {
            System.out.print(targetMovie);
            return new ModelAndView("singleMovie").addObject("targetMovie", targetMovie.get());
        }

    }


}
