package com.mute.Final_BE.dto;
import com.mute.Final_BE.entity.Member;
import com.mute.Final_BE.entity.Musical;
import lombok.Data;
import java.time.LocalDateTime;

// 뮤지컬 후기 - 도연

@Data
public class ReviewMusicalDTO {
    private Long reviewMuId; // 뮤지컬 후기 글 번호
    private Musical musical; // 공연 ID
    private Member member; // 회원번호
    private LocalDateTime writeDate; // 작성일
    private int scoreStory; // 스토리 별점
    private int scoreDirect; // 연출 별점
    private int scoreCast; // 캐스팅 별점
    private int scoreNumber; // 넘버 별점
    private String reviewMuTxt; // 뮤지컬 후기 텍스트
}
