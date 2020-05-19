package com.api.thecat.typesofcat.repository;

import com.api.thecat.typesofcat.domain.AddressCats;
import org.springframework.data.repository.CrudRepository;

public interface AddressCatsRepository extends CrudRepository<AddressCats, String> {

    AddressCats findByName(String name);
}
