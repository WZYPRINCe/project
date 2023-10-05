package com.pigtail.searchService.dao;

import com.pigtail.searchService.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDao extends JpaRepository<Property,Long> {
}
