package com.example.inventory.service;

import com.example.inventory.model.InventoryItem;
import com.example.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryItem> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }

    public Optional<InventoryItem> getInventoryItem(String id) {
        return inventoryRepository.findById(id);
    }

    public InventoryItem createInventoryItem(InventoryItem inventoryItem) {
        return inventoryRepository.save(inventoryItem);
    }

    public InventoryItem updateInventoryItem(String id, InventoryItem itemToUpdate) {
        Optional<InventoryItem> itemOpt = inventoryRepository.findById(id);

        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            item.setCreatedAt(itemToUpdate.getCreatedAt());
            item.setPrice(itemToUpdate.getPrice());
            item.setProductName(itemToUpdate.getProductName());
            item.setQuantity(itemToUpdate.getQuantity());

            return inventoryRepository.save(item);
        } else {
            return null;
        }
    }

    public void deleteInventoryItem(String id) {
        inventoryRepository.deleteById(id);
    }
}
