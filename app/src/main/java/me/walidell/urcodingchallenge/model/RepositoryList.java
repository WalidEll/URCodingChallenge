package me.walidell.urcodingchallenge.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepositoryList {
    @SerializedName("items")
    private ArrayList<Repository> repositories;
}
