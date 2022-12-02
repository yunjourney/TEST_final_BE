package com.mute.Final_BE.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class MusicalInfoDTO {
    @Id
    private Long indexNum; // 인덱스아이디
    private String mt20id; // 공연 ID
    private String prfnm; // 공연이름
    private Date prfpdfrom; // 공연 시작일
    private Date prfpdto; // 공연 종료일
    private String fcltynm; // 공연시설명
    private String prfcast; // 공연출연진
//    private String prfruntime; // 공연 런타임
//    private String prfage; // 공연 관람 연령
//    private String pfgcrew; // 공연제작진
//    private String entrpsnm; // 제작사
//    private String pcseguidance; // 티켓가격
//    private String poster; // 포스터 이미지 경로
//    private String dtguidance; // 공연시간
//    private String styurl; // 소개이미지

}
