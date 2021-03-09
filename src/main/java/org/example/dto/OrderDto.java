package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class OrderDto {

    private Long hotelId;

    private Date dateFrom;

    private Date dateTo;

}
