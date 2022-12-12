package com.mute.Final_BE.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mute.Final_BE.dto.MusicalDetailDTO;
import com.mute.Final_BE.entity.Musical;
import com.mute.Final_BE.repository.MusicalRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
@Component
@Slf4j
public class MusicalDetailApiService {

    @Value("${api.serviceKey}")
    private String key;

    @Autowired
    MusicalRepository musicalRepository;

    public String MusicalDetailApi(@PathVariable String mt20id) {

        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        UriComponents uri = UriComponentsBuilder
                .fromUriString("https://www.kopis.or.kr")
                .path("/openApi/restful/pblprfr/")
                .path(mt20id) // 뮤지컬 id
                .queryParam("service", key) // 인증키
                .encode() // utf-8 로 인코딩
                .build();

        ResponseEntity<String> responseEntity = rest.exchange(uri.toUri(), HttpMethod.GET, requestEntity, String.class);
        String response = responseEntity.getBody();
        return response;
    }


    public List<MusicalDetailDTO> getMapFromJsonObj(String result) {

        List<MusicalDetailDTO> list = new ArrayList<>();

        try {
            // xml 데이터를 json 데이터로 변환
            JSONObject xmlToJson = XML.toJSONObject(result);

            // JSONObject로 데이터 가져오기
            JSONObject jsonObj = xmlToJson.getJSONObject("dbs");

            //log.warn("제이슨바로가져옴" + jsonObj.toString());

            // JSONObject로 가져오기
            JSONObject item = jsonObj.getJSONObject("db");

            // 상세이미지 가져오기.. 못가져옴ㅠㅠ
            JSONObject item2 = item.getJSONObject("styurls");
            JSONArray jsonArr = item2.getJSONArray("styurl");

            String arrStr = jsonArr.toString();
            String[] arrayStr = arrStr.split(",");
//            String tmp1 = arrStr.replace("[", "");
//            String tmp2 = arrStr.replace("]", "");
//            JSONArray jsonArr = new JSONArray(Arrays.asList(arrStr));

            for(String s : arrayStr) {
                String musicalDescImg1 = arrayStr[0];
                String musicalDescImg2 = arrayStr[1];
//                String musicalDescImg3 = arrayStr[2];
//                String musicalDescImg4 = arrayStr[3];

//                musicalDescImg2 = musicalDescImg2.substring(0, musicalDescImg2.length() - 1);

//                musicalDescImg1 = musicalDescImg1.replace("[", "");
//                musicalDescImg2 = musicalDescImg2.replace("]", "");
//                String tmp3 = musicalDescImg3.replace("]", "");
//                String tmp4 = musicalDescImg4.replace("]", "");

                log.warn("이미지주소확인" + s);


            }

            //log.error("스트링배열로바꿈" + jsonArr);

            // DTO에 저장하기
            MusicalDetailDTO musicalDetailDTO = new MusicalDetailDTO(item);
            list.add(musicalDetailDTO);

            //log.warn(musicalDetailDTO.toString());

//            // DB에 저장하기
//            Musical musical = new Musical(item);
//            musicalRepository.save(musical);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}












//        List<Map<String, String>> list = new ArrayList<>();
//        for (int i = 0; i < item.length(); i++) {
//            MusicalDetailDTO musicalDetailDTO = new MusicalDetailDTO(item);
//            list.add((Map<String, String>) musicalDetailDTO);
//
//            for(int e = 0; e < item2.length(); e++) {
//                MusicalDetailDTO musicalDetailDTO2 = new MusicalDetailDTO(item);
//                list.add((Map<String, String>) musicalDetailDTO2);
//            }

//        musicalDetailDTO = mapper.convertValue(jsonObj2.toMap(), MusicalDetailDTO.class);
//        MusicalDetailDTO musicalDetailDTO1 = mapper.convertValue(jsonObj3.toMap(), MusicalDetailDTO.class);

//        log.warn(musicalDetailDTO.toString());
//        log.warn(musicalDetailDTO1.toString());








//        // DTO에 MAP형식으로 저장하기
//        Map<String, String> map = new HashMap<>();
//        Map<String, String> map2 = new HashMap<>();
//
//        ObjectMapper mapper = new ObjectMapper();
//        MusicalDetailDTO musicalDetailDTO = mapper.convertValue(jsonObj2.toMap(), MusicalDetailDTO.class);
//        MusicalDetailDTO musicalDetailDTO2 = mapper.convertValue(jsonParseObj.toMap(), MusicalDetailDTO.class);
//        for(String key : map.keySet()) {
//            musicalDetailDTO.setMusicalId(map.get("mt20id"));
//            musicalDetailDTO.setMusicalName(map.get("prfnm"));
//            musicalDetailDTO.setTheaterName(map.get("fcltynm"));
//            musicalDetailDTO.setTheaterId(map.get("mt10id"));
//            musicalDetailDTO.setMusicalStart(LocalDate.parse(map.get("prfpdfrom")));
//            musicalDetailDTO.setMusicalEnd(LocalDate.parse(map.get("prfpdto")));
//            musicalDetailDTO.setMusicalStatus(map.get("prfstate"));
//            musicalDetailDTO.setMusicalPoster(map.get("poster"));
//            musicalDetailDTO.setMusicalCast(map.get("prfcast"));
//            musicalDetailDTO.setMusicalAge(map.get("prfage"));
//            musicalDetailDTO.setMusicalPrice(map.get("pcseguidance"));
//            musicalDetailDTO.setMusicalPlan(map.get("dtguidance"));
//
//            for(String key2 : map2.keySet()) {
//                musicalDetailDTO2.setMusicalDescImg(map2.get(key2));
//            }
//        } return map ;
//
//
//        try {
//            map = new ObjectMapper().readValue(jsonObj2.toString(), Map.class);
//            map2 = new ObjectMapper().readValue(jsonParseObj.toString(), Map.class);
//
//            for(String key : map.keySet()) {
//                musicalDetailDTO.setMusicalId(map.get("mt20id"));
//                musicalDetailDTO.setMusicalName(map.get("prfnm"));
//                musicalDetailDTO.setTheaterName(map.get("fcltynm"));
//                musicalDetailDTO.setTheaterId(map.get("mt10id"));
//                musicalDetailDTO.setMusicalStart(LocalDate.parse(map.get("prfpdfrom")));
//                musicalDetailDTO.setMusicalEnd(LocalDate.parse(map.get("prfpdto")));
//                musicalDetailDTO.setMusicalStatus(map.get("prfstate"));
//                musicalDetailDTO.setMusicalPoster(map.get("poster"));
//                musicalDetailDTO.setMusicalCast(map.get("prfcast"));
//                musicalDetailDTO.setMusicalAge(map.get("prfage"));
//                musicalDetailDTO.setMusicalPrice(map.get("pcseguidance"));
//                musicalDetailDTO.setMusicalPlan(map.get("dtguidance"));
//
//                for(String key2 : map2.keySet()) {
//                    musicalDetailDTO.setMusicalDescImg(map2.get(key2));
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return map;
