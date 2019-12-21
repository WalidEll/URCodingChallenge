package me.walidell.urcodingchallenge.main_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import java.util.ArrayList;

import me.walidell.urcodingchallenge.R;
import me.walidell.urcodingchallenge.model.Repository;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private MainContract.Presenter presenter;
    private RepositoryRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = MainPresenterImpl.builder()
                .mainView(this)
                .getRepositoryIntractor(new GetRepositoryInteractorImpl())
                .repositories(new ArrayList<>())
                .currentPage(1)
                .build();
        presenter.requestDataFromServer();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(ProgressBar.GONE);
    }

    @Override
    public void setDataToRecyclerView(ArrayList<Repository> repositories) {
        if (adapter!=null){
            adapter.notifyDataSetChanged();
        }else {
            adapter  = new RepositoryRecyclerViewAdapter(repositories);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void updateData(ArrayList<Repository> repositories) {
        presenter.onLoadMore();
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(MainActivity.this,
                "Something went wrong...Error message: " + throwable.getMessage(),
                Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
    private void initView() {
        recyclerView = findViewById(R.id.rv_repositories);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        progressBar=findViewById(R.id.progressBar);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {
                    presenter.onLoadMore();
                }
            }
        });
    }
}
