package me.walidell.urcodingchallenge.main_activity;


import me.walidell.urcodingchallenge.model.RepositoryList;

public interface MainContract {

    interface GetRepositoryIntractor {

        interface OnFinishedListener {
            void onFinished(RepositoryList repositories);
            void onFailure(Throwable t);
        }

        void getTrendingRepositories(OnFinishedListener onFinishedListener);
    }
}
