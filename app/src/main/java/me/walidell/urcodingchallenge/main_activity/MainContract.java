package me.walidell.urcodingchallenge.main_activity;


import java.util.ArrayList;

import me.walidell.urcodingchallenge.model.Repository;
import me.walidell.urcodingchallenge.model.RepositoryList;

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface Presenter{

        void onDestroy();

        void onRefresh();

        void onLoadMore();

        void requestDataFromServer();

    }
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Repository> repositories);
        void updateData(ArrayList<Repository> repositories);

        void onResponseFailure(Throwable throwable);

    }
    interface GetRepositoryIntractor {

        interface OnFinishedListener {
            void onFinished(RepositoryList repositories);
            void onFailure(Throwable t);
        }

        void getTrendingRepositories(int page,OnFinishedListener onFinishedListener);
    }
}
