package com.mute.Final_BE.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class MusicalListDTO {
    @Id
    private Long indexNum; // 인덱스넘버
    private String stdate; // 공연시작일
    private String eddate; // 공연종료일
    private String shprfnm; // 공연명
    private String shprfnmfct; // 공연시설명
    private String prfstate; // 공연상태코드

}
