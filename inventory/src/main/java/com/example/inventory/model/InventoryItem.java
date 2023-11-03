package com.example.inventory.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory_items")
@Data
public class InventoryItem {
    @Id
    private String id; // You can use ObjectId or other appropriate types for MongoDB

    private String productName;
    private Integer quantity;
    private Float price;
    private String createdAt;
}