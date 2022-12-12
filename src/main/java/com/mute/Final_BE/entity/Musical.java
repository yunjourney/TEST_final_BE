package com.mute.Final_BE.entity;

import lombok.*;
import org.json.JSONObject;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter @Setter @ToString
@Table(name = "musical")
@RequiredArgsConstructor
public class Musical {
    @Id
    private String musicalId; // 공연 ID(PK)
    private String musicalName; // 공연 이름

    private LocalDate musicalStart; // 공연 시작일
    private LocalDate musicalEnd; // 공연 종료일

    private String musicalPlan; // 공연 스케줄(월, 수 19:00)
    private String theaterName; // 공연장 이름
    private LocalDate musicalTicketStart; // 공연 예매 시작일
    private String musicalStatus; // 공연 상태 (공연예정, 공연중, 공연종료)
    private String musicalPoster; // 공연 포스터

    // api 호출 후 DB에 저장
    public Musical (JSONObject item) {
        String tmp1 = item.getString("prfpdfrom");
        String tmp2 = item.getString("prfpdto");

        this.musicalId = item.getString("mt20id");
        this.musicalName = item.getString("prfnm");
        this.theaterName = item.getString("fcltynm");
        this.musicalStart = LocalDate.parse(tmp1.replace(".", "-"));
        this.musicalEnd = LocalDate.parse(tmp2.replace(".", "-"));
        this.musicalStatus = item.getString("prfstate");
        this.musicalPoster = item.getString("poster");
    }
}