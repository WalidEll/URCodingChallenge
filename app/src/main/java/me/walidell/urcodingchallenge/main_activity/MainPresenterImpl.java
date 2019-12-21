package me.walidell.urcodingchallenge.main_activity;

import lombok.AllArgsConstructor;
import me.walidell.urcodingchallenge.model.RepositoryList;

@AllArgsConstructor
public class MainPresenterImpl implements MainContract.Presenter,MainContract.GetRepositoryIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetRepositoryIntractor getRepositoryIntractor;


    @Override
    public void onDestroy() {
        mainView=null;
    }

    @Override
    public void onRefresh() {
        if(mainView != null){
            mainView.showProgress();
        }
        getRepositoryIntractor.getTrendingRepositories(this);
    }

    @Override
    public void requestDataFromServer() {
        getRepositoryIntractor.getTrendingRepositories(this);
    }

    @Override
    public void onFinished(RepositoryList repositories) {
        if(mainView != null){
            mainView.setDataToRecyclerView(repositories);
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
