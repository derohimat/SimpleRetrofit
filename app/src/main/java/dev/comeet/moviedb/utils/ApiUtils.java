package dev.comeet.moviedb.utils;

import dev.comeet.moviedb.network.MovieService;
import dev.comeet.moviedb.network.RetrofitClient;

public class ApiUtils {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    public static MovieService getMovieService() {
        return RetrofitClient.getClient(BASE_URL).create(MovieService.class);
    }
}