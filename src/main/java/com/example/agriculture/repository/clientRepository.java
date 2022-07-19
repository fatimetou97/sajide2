package com.example.agriculture.repository;

import com.example.agriculture.model.client;
import com.example.agriculture.model.region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clientRepository  extends JpaRepository<client,Long> {
}
