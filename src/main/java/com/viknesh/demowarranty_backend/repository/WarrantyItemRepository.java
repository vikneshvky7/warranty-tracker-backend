package com.viknesh.demowarranty_backend.repository;

import com.viknesh.demowarranty_backend.model.warrantyItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarrantyItemRepository extends JpaRepository<warrantyItem, Long> {
}
