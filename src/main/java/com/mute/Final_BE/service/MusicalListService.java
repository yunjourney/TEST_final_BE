//package com.mute.Final_BE.service;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mute.Final_BE.repository.MusicalListRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.json.XML;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@Service
//@Slf4j
//public class MusicalListService {
//
//    private MusicalListRepository musicalListRepository;
//    public MusicalListService(MusicalListRepository musicalListRepository) {
//        this.musicalListRepository = musicalListRepository;
//    }
//
//    private String key="5a64fe18bbc04f6aaedbedbe0e9dfa13";
//
//    public String MusicalList() {
//        try {
//            UriComponents uri = UriComponentsBuilder
//                    .fromUriString("https://www.kopis.or.kr")
//                    .path("/openApi/restful/pblprfr/")
//                    .queryParam("service", key) // 인증키
//                    .queryParam("stdate", 20221001) // 공연시작일
//                    .queryParam("eddate", 20230401) // 공연종료일
//                    .queryParam("cpage", 1) // 현재 페이지
//                    .queryParam("rows", 5) // 페이지 당 목록 수
//                    .queryParam("signgucode", 11) // 지역코드(11 = 서울)
//                    .queryParam("shcate", "AAAB") // 장르코드(AAAB = 뮤지컬)
//                    .encode() // utf-8 로 인코딩
//                    .build();
//
//            RestTemplate restTemplate = new RestTemplate();
//
//            // api를 호출하여 결과를 가져온 다음 String형태로 먼저 받음
//            // RestTemplate.getForObject(URI url, Class<T> responseType) => (호출하는 url, 반환타입)
//            String response = restTemplate.getForObject(uri.toUri(), String.class);
//
//            // xml 데이터를 json 데이터로 변환
//            org.json.JSONObject jsonObj1 = XML.toJSONObject(response);
//
////            // 파싱해서 데이터 분리하기
////            JSONParser jsonParser = new JSONParser();
////            JSONObject jsonParseObj = (JSONObject) jsonParser.parse(jsonObj1.toString());
//
//            // JSONObject로 데이터 가져오기
//            JSONObject jsonObj2 = (JSONObject) jsonObj1.get("dbs");
//
//            // 배열형식이니 JSONArray로 가져오기
//            JSONArray jsonArr = (JSONArray) jsonObj2.get("db");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "어쩌라고";
//
//    }
//}