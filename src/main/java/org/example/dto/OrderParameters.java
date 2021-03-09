package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderParameters {
    private Long hotelId;

    private Date dateFrom;
    private Date dateTo;
}
