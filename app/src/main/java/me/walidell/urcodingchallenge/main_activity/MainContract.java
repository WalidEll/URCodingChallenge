package me.walidell.urcodingchallenge.main_activity;


import me.walidell.urcodingchallenge.model.RepositoryList;

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface Presenter{

        void onDestroy();

        void onRefresh();

        void requestDataFromServer();

    }
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(RepositoryList repositories);

        void onResponseFailure(Throwable throwable);

    }
    interface GetRepositoryIntractor {

        interface OnFinishedListener {
            void onFinished(RepositoryList repositories);
            void onFailure(Throwable t);
        }

        void getTrendingRepositories(OnFinishedListener onFinishedListener);
    }
}
