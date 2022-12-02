package com.mute.Final_BE.repository;

import com.mute.Final_BE.dto.MusicalListDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalListRepository extends JpaRepository<MusicalListDTO, Long> {
}
