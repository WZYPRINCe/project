package com.pigtail.searchService.dao;

import com.pigtail.searchService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Long> {
}
