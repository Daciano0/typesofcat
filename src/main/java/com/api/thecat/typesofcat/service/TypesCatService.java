package com.api.thecat.typesofcat.service;

import com.api.thecat.typesofcat.criteria.CriteriaBuilder;
import com.api.thecat.typesofcat.repository.AddressCatsRepository;
import com.api.thecat.typesofcat.repository.TypesCatRepository;
import com.api.thecat.typesofcat.domain.AddressCats;
import com.api.thecat.typesofcat.domain.CatBreeds;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@AllArgsConstructor
@Service
public class TypesCatService {

    private TypesCatRepository typesCatRepository;

    private AddressCatsRepository addressCatsRepository;

    private CriteriaBuilder criteriaBuilder;

    //Criteria
    public List<CatBreeds> queriesBuilder(String breed, String temperament, String origin) {

        List<CatBreeds> list = criteriaBuilder.getListByQueries(breed, temperament, origin);

        if(list.size() > 0){
            list.forEach(catBreeds -> {
                AddressCats addressCats = addressCatsRepository.findByName(catBreeds.getName());
                catBreeds.setAddressCats(addressCats);
            });
        }

        return list;
    }

    public List<CatBreeds> getList() {

        List<CatBreeds> list = new ArrayList<>();
        //Threds
        typesCatRepository.findAll().iterator().forEachRemaining(list::add);

        return list;
    }

    public CatBreeds getCatByBreeds(String breed) {

        CatBreeds catBreeds = typesCatRepository.findByName(breed);

        if(catBreeds != null){
            AddressCats addressCats = addressCatsRepository.findByName(catBreeds.getName());

            catBreeds.setAddressCats(addressCats);
        }
        return catBreeds;
    }

    public List<CatBreeds> getListByTemperament(String temperament) {

        return typesCatRepository.findAllByTemperamentLike(temperament);
    }

    public List<CatBreeds> getListByOrigin(String origin) {

        return typesCatRepository.findAllByOrigin(origin);
    }
}
