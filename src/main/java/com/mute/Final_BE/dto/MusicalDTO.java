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
    private String musicalId; // 공연 ID(PK)
    private String musicalName; // 공연 이름
    private String theaterName; // 공연장 이름

    private LocalDate musicalStart; // 공연 시작일
    private LocalDate musicalEnd; // 공연 종료일

    private LocalDate musicalTicketStart; // 티켓 예매 시작일
    private String musicalStatus; // 공연 상태 (공연예정/공연중/공연종료)
    private String musicalPoster; // 공연 포스터

    // api DTO에 저장
    public MusicalDTO (JSONObject itemJson) {
        String tmp1 = itemJson.getString("prfpdfrom");
        String tmp2 = itemJson.getString("prfpdto");

        this.musicalId = itemJson.getString("mt20id");
        this.musicalName = itemJson.getString("prfnm");
        this.theaterName = itemJson.getString("fcltynm");
        this.musicalStart = LocalDate.parse(tmp1.replace(".", "-"));
        this.musicalEnd = LocalDate.parse(tmp2.replace(".", "-"));
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



