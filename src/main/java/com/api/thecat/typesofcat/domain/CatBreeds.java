package com.api.thecat.typesofcat.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Document(collection = "catBreeds")
public class CatBreeds implements Serializable {

    @JsonIgnore
    private String id = UUID.randomUUID().toString();

    private String origin;
    private String temperament;
    private String name;
    private AddressCats addressCats;

    @CreatedDate
    private Date createAt;
}
