package com.ddgroup.h3monitor.repository;

import com.ddgroup.h3monitor.model.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
