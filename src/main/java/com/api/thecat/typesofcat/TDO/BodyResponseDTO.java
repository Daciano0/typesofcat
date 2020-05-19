package com.api.thecat.typesofcat.TDO;

import lombok.Data;

import java.util.List;

@Data
public class BodyResponseDTO {

    private String category;
    private int categoryId;
    private String url;

}
