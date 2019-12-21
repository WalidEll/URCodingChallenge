package me.walidell.urcodingchallenge.main_activity;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

import me.walidell.urcodingchallenge.config.RetrofitInstance;
import me.walidell.urcodingchallenge.model.RepositoryList;
import me.walidell.urcodingchallenge.service.RepositoryService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetRepositoryInteractorImpl implements MainContract.GetRepositoryIntractor {
    @Override
    public void getTrendingRepositories(final OnFinishedListener onFinishedListener) {
        RepositoryService repositoryService = RetrofitInstance.getRetrofitInstance().create(RepositoryService.class);
        Date date = new Date();
        String strDate = new SimpleDateFormat("created:>yyyy-MM-dd").format(date);
        String query = "created:>"+strDate;
        Call<RepositoryList> repositoryListCall = repositoryService.search(query,"stars","desc",1);

        /**Log the URL called*/
        Log.wtf("URL Called", repositoryListCall.request().url() + "");

        repositoryListCall.enqueue(new Callback<RepositoryList>() {
            @Override
            public void onResponse(Call<RepositoryList> call, Response<RepositoryList> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<RepositoryList> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
