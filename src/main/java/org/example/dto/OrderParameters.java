package org.example.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class OrderParameters {
    private Long hotelId;

    private String dateFrom;
    private String dateTo;

}
