package com.mute.Final_BE.repository;

import com.mute.Final_BE.entity.Musical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalRepository extends JpaRepository<Musical, String> {
}
