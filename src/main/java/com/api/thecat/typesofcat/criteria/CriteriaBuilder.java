package com.api.thecat.typesofcat.criteria;

import com.api.thecat.typesofcat.TDO.EventLogDTO;
import com.api.thecat.typesofcat.domain.CatBreeds;
import com.api.thecat.typesofcat.enums.EventsEnum;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Log4j2
@AllArgsConstructor
@Component
public class CriteriaBuilder {

    private final MongoTemplate mongoTemplate;

    private Query query;

    public List<CatBreeds> getListByQueries(String breed, String temperament, String origin) {

        getListByBreed(breed);
        getListByTemperament(temperament);
        getListByOrigin(origin);

        List<CatBreeds> catBreeds = mongoTemplate.find(this.query, CatBreeds.class);
        query  = new Query();
        return catBreeds;
    }

    private void getListByBreed(String breed){

        if(StringUtils.isNotEmpty(breed)){
            log.info(new EventLogDTO(EventsEnum.REQUEST, "genarator of cat type: "+breed).toString());
            query.addCriteria(Criteria.where("name").is(breed));
        }
    }

    private void getListByTemperament(String temperament){



        if(StringUtils.isNotEmpty(temperament)){
            log.info(new EventLogDTO(EventsEnum.REQUEST, "genarator of cat type: "+temperament).toString());
            query.addCriteria(Criteria.where("temperament").regex(temperament));
        }
    }

    private void getListByOrigin(String origin){

        if(StringUtils.isNotEmpty(origin)){
            log.info(new EventLogDTO(EventsEnum.REQUEST, "genarator of cat type: "+origin).toString());
            query.addCriteria(Criteria.where("origin").is(origin));
        }
    }

}
