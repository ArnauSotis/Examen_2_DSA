package edu.upc.eetac.dsa.repositorisinfo.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import edu.upc.eetac.dsa.repositorisinfo.R;
import edu.upc.eetac.dsa.repositorisinfo.adapter.ReposListAdapter;
import edu.upc.eetac.dsa.repositorisinfo.model.Repo;
import edu.upc.eetac.dsa.repositorisinfo.service.ReposApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepoListActivity extends AppCompatActivity {

    private static final String URL_BASE = "https://api.github.com/";
    private Retrofit retrofit=null;
    private RecyclerView rwRepollistat = null;
    private String nomUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);

        rwRepollistat = (RecyclerView) findViewById(R.id.recycler_view);
        rwRepollistat.setHasFixedSize(true);
        rwRepollistat.setLayoutManager(new LinearLayoutManager(this));

        nomUser = getIntent().getExtras().getString("nomUser").toString();

        connectReposService();
    }

    /*
    ** These method create an instance of Retrofit from URL_BASE
     */
    public void connectReposService () {
        if (this.retrofit == null) {
            this.retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ReposApiService reposApiService = retrofit.create(ReposApiService.class);

        Call<List<Repo>> call = reposApiService.getReposByUser(nomUser);
        call.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repos = response.body();
                rwRepollistat.setAdapter(new ReposListAdapter(repos, R.layout.list_item_repo_layout, getApplicationContext()));

                Log.d("repos", "nombre de repositoris: " + repos.size());
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                Log.e("repos", t.toString());
            }
        });
    }


}
