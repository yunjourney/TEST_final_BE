package com.mute.Final_BE.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class MusicalDTO {

    private String musicalId; // 공연 ID
    private String musicalName; // 공연명
    private String theaterName; // 공연시설명

    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private String musicalStart; // 공연시작일
    @JsonFormat(pattern = "yyyy.MM.dd")
    private String musicalEnd; // 공연종료일

    private Date musicalTicketStart; // 티켓 예매 시작일
    private String musicalStatus; // 공연상태코드
    private String musicalPoster; // 포스터 경로

    public MusicalDTO (JSONObject itemJson) {
        this.musicalId = itemJson.getString("mt20id");
        this.musicalName = itemJson.getString("prfnm");
        this.theaterName = itemJson.getString("fcltynm");
        this.musicalStart = itemJson.getString("prfpdfrom");
        this.musicalEnd = itemJson.getString("prfpdto");
        this.musicalStatus = itemJson.getString("prfstate");
        this.musicalPoster = itemJson.getString("poster");
    }
}

//    private String prfcast; // 공연 출연진
//    private String prfcrew; // 공연 제작진
//    private String prfruntime; // 공연 시간
//    private String dtguidance; // 공연 일정 스케줄
//    private String prfage; // 공연 관람연령
//    private String entrpsnm; // 공연 제작사
//    private String pcseguidance; // 좌석 등급별 가격
//    private String styurl; // 상세이미지 경로
//    private String mt10id; // 공연장 ID


//    private List<String> services; // 서비스..테스트용



