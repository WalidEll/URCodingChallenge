package me.walidell.urcodingchallenge.service;


import me.walidell.urcodingchallenge.model.RepositoryList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepositoryService {
    @GET("search/repositories")
    Call<RepositoryList> search(@Query("q") String query, @Query("sort") String sort, @Query("order") String order, @Query("page") int page);
}
