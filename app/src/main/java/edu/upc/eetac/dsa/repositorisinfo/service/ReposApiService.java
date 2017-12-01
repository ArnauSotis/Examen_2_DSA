package edu.upc.eetac.dsa.repositorisinfo.service;

import java.util.List;

import edu.upc.eetac.dsa.repositorisinfo.model.Repo;
import edu.upc.eetac.dsa.repositorisinfo.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by lluis on 30/11/17.
 */

public interface ReposApiService {

    @GET("users/{user}/repos")
    Call<List<Repo>>  getReposByUser(@Path("user") String user);

    @GET("users/{user}")
    Call<User>  getInfoUser(@Path("user") String user);

    //@GET("")

}
