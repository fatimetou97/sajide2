package com.example.agriculture.repository;

import com.example.agriculture.model.publication;
import com.example.agriculture.model.region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface publicationRepository extends JpaRepository<publication,Long>{
    List<region> getAllByRegion(region region);
}
