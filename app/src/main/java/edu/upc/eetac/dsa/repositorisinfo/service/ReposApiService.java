package edu.upc.eetac.dsa.repositorisinfo.service;

import java.util.List;

import edu.upc.eetac.dsa.repositorisinfo.model.Repo;
import edu.upc.eetac.dsa.repositorisinfo.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lluis on 30/11/17.
 */

public interface ReposApiService {

    @GET("users/{user}/repos")
    Call<List<Repo>>  getReposByUser(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<List<Repo>>  getReposByUserSort(@Path("user") String user, @Query("sort") String sort);

    @GET("users/{user}")
    Call<User>  getInfoUser(@Path("user") String user);

    @GET("search/repositories/")
    Call<List<Repo>>  getSearchRepos(@Query("q") String query);
}
