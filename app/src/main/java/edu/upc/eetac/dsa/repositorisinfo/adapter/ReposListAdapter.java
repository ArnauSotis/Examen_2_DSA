package edu.upc.eetac.dsa.repositorisinfo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import edu.upc.eetac.dsa.repositorisinfo.R;
import edu.upc.eetac.dsa.repositorisinfo.model.Repo;


/**
 * Created by lluis on 30/11/17.
 */

public class ReposListAdapter extends RecyclerView.Adapter<ReposListAdapter.ReposViewHolder> {

    private List<Repo> repos;
    private int rowLayout;
    private Context context;

    public ReposListAdapter(List<Repo> repos, int rowLayout, Context context) {
        this.repos = repos;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ReposViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ReposViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReposViewHolder holder, int position) {
        holder.name.setText(repos.get(position).getName());
        holder.llenguatge.setText(repos.get(position).getLanguage());
        holder.descrip.setText(repos.get(position).getDescription());
        holder.url.setText(repos.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    //A view holder inner class where we get reference to the views in the layout using their ID
    public static class ReposViewHolder extends RecyclerView.ViewHolder {
        LinearLayout reposLayout;
        TextView name;
        TextView llenguatge;
        TextView descrip;
        TextView url;

        public ReposViewHolder (View v) {
            super(v);
            reposLayout = (LinearLayout) v.findViewById(R.id.repos_layout);
            name = (TextView) v.findViewById(R.id.name);
            url = (TextView) v.findViewById(R.id.url);
            descrip = (TextView) v.findViewById(R.id.description);
            llenguatge = (TextView) v.findViewById(R.id.language);
        }
    }
}
