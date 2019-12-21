package me.walidell.urcodingchallenge.main_activity;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import me.walidell.urcodingchallenge.config.RetrofitInstance;
import me.walidell.urcodingchallenge.model.RepositoryList;
import me.walidell.urcodingchallenge.service.RepositoryService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetRepositoryInteractorImpl implements MainContract.GetRepositoryIntractor {
    @Override
    public void getTrendingRepositories(int page,final OnFinishedListener onFinishedListener) {
        RepositoryService repositoryService = RetrofitInstance.getRetrofitInstance().create(RepositoryService.class);

        String query = "created:>" + getLastMonthDate();
        Call<RepositoryList> repositoryListCall = repositoryService.search(query,"stars","desc",page);

        /*Log the URL called*/
        Log.wtf("URL Called", repositoryListCall.request().url() + "");

        repositoryListCall.enqueue(new Callback<RepositoryList>() {
            @Override
            public void onResponse(Call<RepositoryList> call, Response<RepositoryList> response) {
                onFinishedListener.onFinished(response.body());
            }

            @Override
            public void onFailure(Call<RepositoryList> call, Throwable t) {
                Log.wtf("URL Called", t + "");
                onFinishedListener.onFailure(t);
            }
        });

    }

    private String getLastMonthDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return formatter.format(calendar.getTime());
    }

}
