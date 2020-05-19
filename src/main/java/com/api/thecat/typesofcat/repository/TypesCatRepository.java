package com.api.thecat.typesofcat.repository;

import com.api.thecat.typesofcat.domain.CatBreeds;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypesCatRepository extends CrudRepository<CatBreeds, String> {

    CatBreeds findByName(String breed);

    List<CatBreeds> findAllByTemperamentLike(String temperament);

    List<CatBreeds> findAllByOrigin(String origin);
}
