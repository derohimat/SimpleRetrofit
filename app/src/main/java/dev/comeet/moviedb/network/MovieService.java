package dev.comeet.moviedb.network;

import dev.comeet.moviedb.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("discover/movie")
    Call<MovieResponse> getMovies(@Query("api_key") String apiKey,
                                  @Query("language") String language);

}