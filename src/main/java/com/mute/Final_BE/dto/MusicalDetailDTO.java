package com.mute.Final_BE.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class MusicalDetailDTO {
    private String musicalId; // 공연 ID(PK)
    private String musicalName; // 공연 이름
    private String theaterName; // 공연장 이름
    private String theaterId; // 공연장 ID
    private LocalDate musicalStart; // 공연 시작일
    private LocalDate musicalEnd; // 공연 종료일
    private String musicalStatus; // 공연 상태 (공연예정/공연중/공연종료)
    private String musicalPoster; // 공연 포스터
    private String musicalCast; // 공연 출연진 (박효신, 박은태, 조정은, 옥주현)
    private String musicalAge; // 공연 관람 연령 (만 0세 이상)
    private String musicalPrice; // 좌석별 가격 (R석 170,000원, S석 140,000원, A석 110,000원, B석 80,000원)
    private String musicalDescImg1; // 상세이미지1
    private String musicalDescImg2; // 상세이미지2
    private String musicalDescImg3; // 상세이미지3
    private String musicalDescImg4; // 상세이미지4
    private String musicalPlan; // 공연 스케줄(화요일(19:30), 수요일(14:30,19:30), 목요일(19:30), 금요일 ~ 토요일(14:30,19:30), 일요일(15:00))

    // api DTO에 저장
    public MusicalDetailDTO (JSONObject item) {
        String tmp1 = item.getString("prfpdfrom");
        String tmp2 = item.getString("prfpdto");

        this.musicalId = item.getString("mt20id");
        this.musicalName = item.getString("prfnm");
        this.theaterName = item.getString("fcltynm");
        this.theaterId = item.getString("mt10id");
        this.musicalStart = LocalDate.parse(tmp1.replace(".", "-"));
        this.musicalEnd = LocalDate.parse(tmp2.replace(".", "-"));
        this.musicalStatus = item.getString("prfstate");
        this.musicalPoster = item.getString("poster");
        this.musicalCast = item.getString("prfcast");
        this.musicalAge = item.getString("prfage");
        this.musicalPrice = item.getString("pcseguidance");
//        this.musicalDescImg1 = item.getString("styurl");
//        this.musicalDescImg2 = item.getString("styurl");
//        this.musicalDescImg3 = item.getString("styurl");
//        this.musicalDescImg4 = item.getString("styurl");
        this.musicalPlan = item.getString("dtguidance");
    }

//    public void MusicalDetailDTO2 (JSONObject item2) {
//        this.musicalDescImg = item2.getString("styurl");
//    }

}

//<dbs>
//<db>
//<mt20id>PF202217</mt20id>
//<prfnm>베토벤</prfnm>
//<prfpdfrom>2023.01.12</prfpdfrom>
//<prfpdto>2023.03.26</prfpdto>
//<fcltynm>예술의전당 (오페라극장)</fcltynm>
//<prfcast>박효신, 박은태, 조정은, 옥주현, 윤공주, 이해준, 윤소호</prfcast>
//<prfcrew>엄홍현, 왕용범, 이단비 등</prfcrew>
//<prfruntime> </prfruntime>
//<prfage>만 7세 이상</prfage>
//<entrpsnm> </entrpsnm>
//<pcseguidance>R석 170,000원, S석 140,000원, A석 110,000원, B석 80,000원</pcseguidance>
//<poster>http://www.kopis.or.kr/upload/pfmPoster/PF_PF202217_221115_164026.gif</poster>
//<sty> </sty>
//<genrenm>뮤지컬</genrenm>
//<prfstate>공연예정</prfstate>
//<openrun>N</openrun>
//<styurls>
//<styurl>http://www.kopis.or.kr/upload/pfmIntroImage/PF_PF202217_221115_0440260.jpg</styurl>
//</styurls>
//<mt10id>FC000001</mt10id>
//<dtguidance>화요일(19:30), 수요일(14:30,19:30), 목요일(19:30), 금요일 ~ 토요일(14:30,19:30), 일요일(15:00)</dtguidance>
//</db>
//</dbs>
