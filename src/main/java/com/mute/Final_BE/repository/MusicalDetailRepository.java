package com.mute.Final_BE.repository;

import com.mute.Final_BE.dto.MusicalInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicalDetailRepository extends JpaRepository<MusicalInfoDTO, Long> {
}
