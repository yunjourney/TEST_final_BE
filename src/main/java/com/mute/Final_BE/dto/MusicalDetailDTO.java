package com.mute.Final_BE.dto;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class MusicalDetailDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long indexNum; // 인덱스넘버

    private String mt20id; // 공연 ID
    private String prfnm; // 공연명
    private String fcltynm; // 공연시설명

    private String prfpdfrom; // 공연시작일
    private String prfpdto; // 공연종료일
    private String prfstate; // 공연상태코드
    private String poster; // 포스터 경로

    private String prfcast; // 공연 출연진
    private String prfcrew; // 공연 제작진
    private String prfruntime; // 공연 시간
    private String dtguidance; // 공연 일정 스케줄
    private String prfage; // 공연 관람연령
    private String entrpsnm; // 공연 제작사
    private String pcseguidance; // 좌석 등급별 가격
    private String styurl; // 상세이미지 경로
    private String mt10id; // 공연장 ID


    public MusicalDetailDTO (String prfcast, String prfcrew, String dtguidance) {
        this.prfcast = prfcast;
        this.prfcrew = prfcrew;
        this.dtguidance = dtguidance;
    }


    public MusicalDetailDTO() {

    }
}
