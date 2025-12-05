package com.viknesh.demowarranty_backend.controller;

import com.viknesh.demowarranty_backend.model.warrantyItem;
import com.viknesh.demowarranty_backend.repository.WarrantyItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@CrossOrigin(origins = "*") // allow frontend from any domain
public class WarrantyItemController {

    private final WarrantyItemRepository repository;

    public WarrantyItemController(WarrantyItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<warrantyItem> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    @PostMapping
    public warrantyItem create(@RequestBody warrantyItem item) {
        return repository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<warrantyItem> update(
            @PathVariable Long id,
            @RequestBody warrantyItem updated
    ) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setProductName(updated.getProductName());
                    existing.setCategory(updated.getCategory());
                    existing.setPurchaseDate(updated.getPurchaseDate());
                    existing.setWarrantyMonths(updated.getWarrantyMonths());
                    existing.setStoreName(updated.getStoreName());
                    existing.setInvoiceNumber(updated.getInvoiceNumber());
                    existing.setNotes(updated.getNotes());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
