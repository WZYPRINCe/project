package com.pigtail.searchService.dao;

import com.pigtail.searchService.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image,Long> {
}
