package me.walidell.urcodingchallenge;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import me.walidell.urcodingchallenge.config.RetrofitInstance;
import me.walidell.urcodingchallenge.model.RepositoryList;
import me.walidell.urcodingchallenge.service.RepositoryService;
import retrofit2.Call;
import retrofit2.Response;

import static junit.framework.TestCase.assertTrue;

public class RepositoryServiceTest {
    @Test
    public void testSearchTrendingRepo(){
        RepositoryService repositoryService = RetrofitInstance.getRetrofitInstance().create(RepositoryService.class);

        Call<RepositoryList> repositoryListCall = repositoryService.search("created:>2017-10-22","stars","desc",1);
        try {
            Response<RepositoryList> response = repositoryListCall.execute();
            assertTrue(response.isSuccessful());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
