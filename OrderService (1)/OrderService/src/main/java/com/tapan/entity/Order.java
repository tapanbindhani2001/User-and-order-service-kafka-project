package com.tapan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection = "order_collection")
public class Order {
    private String id;
    private String UserId;
    private String product;
    private Integer price;
}
