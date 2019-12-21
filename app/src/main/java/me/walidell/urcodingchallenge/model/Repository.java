package me.walidell.urcodingchallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Repository {
    private String id;
    private String name;
    private String description;
    private Owner owner;
    private int stars;
}
