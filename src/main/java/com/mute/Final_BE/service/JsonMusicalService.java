//package com.mute.Final_BE.service;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.json.JSONObject;
//import org.json.XML;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class JsonMusicalService {
//    private String key="5a64fe18bbc04f6aaedbedbe0e9dfa13";
//    private String mt20id="PF202217";
//
////    @GetMapping("/musical")
//    public Map<String, Object> MusicalDetail() {
//        Map<String, Object> map = new HashMap<>();
//
//        try {
//            UriComponents uri = UriComponentsBuilder
//                    .fromUriString("https://www.kopis.or.kr")
//                    .path("/openApi/restful/pblprfr/")
//                    .path(mt20id) // 뮤지컬 id (임시 : 베토벤 id)
//                    .queryParam("service", key) // 인증키
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
//            JSONObject jsonObj1 = XML.toJSONObject(response);
//
//            // 데이터에서 꺼내쓰기
//            JSONObject jsonObj2 = jsonObj1.getJSONObject("dbs").getJSONObject("db");
//
//            log.info("데이터 확인 : " + jsonObj2.toString());
//
//
////            JSONArray jsonArr = jsonObj2.getJSONArray("db");
////            for(int i = 1; i < jsonArr.length(); i++) {
////                String prfpdfrom = jsonArr.getJSONObject(i).getString("prfpdfrom");
////                String prfpdto = jsonArr.getJSONObject(i).getString("prfpdto");
////                String prfnm = jsonArr.getJSONObject(i).getString("prfnm");
////                String fcltynm = jsonArr.getJSONObject(i).getString("fcltynm");
////            }
////
////            log.info("배열확인 : " + jsonArr);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
//}
