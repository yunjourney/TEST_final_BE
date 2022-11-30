package com.mute.Final_BE.repository;
import com.mute.Final_BE.entity.ReviewMusical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// 도연 - 뮤지컬 리뷰 작업중..

public interface ReviewMusicalRepository extends JpaRepository<ReviewMusical, Long> {
//    List<ReviewMusical> findById()
}
