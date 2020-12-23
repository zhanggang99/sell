package com.zg.sell.repository;

import com.zg.sell.domain.Mood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<Mood,String> {
}
