package me.walidell.urcodingchallenge.main_activity;

import java.util.ArrayList;


import lombok.Builder;
import me.walidell.urcodingchallenge.model.Repository;
import me.walidell.urcodingchallenge.model.RepositoryList;

@Builder

public class MainPresenterImpl implements MainContract.Presenter,MainContract.GetRepositoryIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetRepositoryIntractor getRepositoryIntractor;
    private int currentPage;

    private ArrayList<Repository> repositories;


    @Override
    public void onDestroy() {
        mainView=null;
    }

    @Override
    public void onRefresh() {
        if(mainView != null){
            mainView.showProgress();
            currentPage=1;
            getRepositoryIntractor.getTrendingRepositories(currentPage,this);
        }

    }

    @Override
    public void onLoadMore() {
        if(mainView != null){
            mainView.showProgress();
            currentPage++;
            getRepositoryIntractor.getTrendingRepositories(currentPage,this);
        }

    }

    @Override
    public void requestDataFromServer() {
        if(mainView != null) {
            mainView.showProgress();
            getRepositoryIntractor.getTrendingRepositories(currentPage, this);
        }
    }

    @Override
    public void onFinished(RepositoryList repositoriesList) {
        if(mainView != null){
            this.repositories.addAll(repositoriesList.getRepositories());
            mainView.setDataToRecyclerView(this.repositories);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
