package me.walidell.urcodingchallenge.main_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.walidell.urcodingchallenge.R;
import me.walidell.urcodingchallenge.model.Repository;
import me.walidell.urcodingchallenge.utils.AppUtils;

public class RepositoryRecyclerViewAdapter extends RecyclerView.Adapter<RepositoryRecyclerViewAdapter.RepositoryViewHolder> {

    private ArrayList<Repository> repositories;

    // Constructor to initialize data
    public RepositoryRecyclerViewAdapter(ArrayList<Repository> repositories) {
        this.repositories = repositories;
    }


    // Creating the view Holder
    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.repository_layout_item, parent, false);
        return new RepositoryViewHolder(view);
    }

    // Binding data to view
    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        Repository repository = repositories.get(position);
        holder.binde(repository);
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }
    class RepositoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_repo_name;
        TextView tv_repo_description;
        TextView tv_owner_name;
        TextView tv_stars_count;
        ImageView imgv_owner_avatar;

        // getting itemView components
        public RepositoryViewHolder(View itemView) {
            super(itemView);
            tv_repo_name = itemView.findViewById(R.id.tv_repo_name);
            tv_repo_description = itemView.findViewById(R.id.tv_repo_description);
            tv_owner_name = itemView.findViewById(R.id.tv_owner_name);
            tv_stars_count = itemView.findViewById(R.id.tv_stars_count);
            imgv_owner_avatar = itemView.findViewById(R.id.imgv_owner_avatar);
        }

        // method to bind values to the item view
        public void binde(Repository repository) {
            tv_repo_name.setText(repository.getName());
            tv_repo_description.setText(repository.getDescription());
            tv_owner_name.setText(repository.getOwner().getLogin());
            tv_stars_count.setText(AppUtils.formatStars(repository.getStars()));
            Picasso.get().load(repository.getOwner().getAvatar_url()).resize(90, 90).into(imgv_owner_avatar);

        }
    }
}
