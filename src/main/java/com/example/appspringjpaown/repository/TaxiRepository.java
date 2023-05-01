package com.example.appspringjpaown.repository;

import com.example.appspringjpaown.model.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxiRepository extends JpaRepository<Taxi, Integer> {
}
