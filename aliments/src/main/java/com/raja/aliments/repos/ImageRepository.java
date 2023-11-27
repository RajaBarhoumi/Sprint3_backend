package com.raja.aliments.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raja.aliments.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}

