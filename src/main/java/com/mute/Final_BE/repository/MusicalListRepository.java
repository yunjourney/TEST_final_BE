package com.mute.Final_BE.repository;

import com.mute.Final_BE.dto.MusicalListDTO;
import com.mute.Final_BE.entity.Musical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalListRepository extends JpaRepository<Musical, Long> {
}
