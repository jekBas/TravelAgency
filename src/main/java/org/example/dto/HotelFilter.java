package org.example.dto;


import lombok.Getter;
import lombok.Setter;
import org.example.model.Country;

import javax.persistence.Enumerated;

@Getter
@Setter
public class HotelFilter {

    @Enumerated
    private Country country;

}
