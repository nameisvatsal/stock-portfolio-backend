package com.portfolio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Stock {
    @Id
    private String ticker;
    private String name;
    private int quantity;
    private double buyPrice;
    private double currentPrice;
}
