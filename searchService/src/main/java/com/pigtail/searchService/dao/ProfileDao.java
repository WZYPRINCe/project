package com.pigtail.searchService.dao;

import com.pigtail.searchService.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDao extends JpaRepository<Profile,Long> {
}
