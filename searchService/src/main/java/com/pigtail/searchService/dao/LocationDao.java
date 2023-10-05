package com.pigtail.searchService.dao;

import com.pigtail.searchService.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDao extends JpaRepository<Location,Long> {
}
