package com.example.bakery.SERVER.API.DTO;

import javax.validation.constraints.NotNull;

@SuppressWarnings("unused")
public class GeneralModelDTO {

    @NotNull
    private Long id;

    @NotNull
    private String type;


    public GeneralModelDTO(Long id, String type) {
        this.id = id;
        this.type = type;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}