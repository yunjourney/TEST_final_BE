package com.mute.Final_BE.controller;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mute.Final_BE.dto.MusicalDetailDTO;
import com.mute.Final_BE.dto.MusicalListDTO;
import com.mute.Final_BE.repository.MusicalListRepository;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import com.mute.Final_BE.repository.MusicalDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.DataInput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/json")
public class MusicalDetailController {

        @Autowired
        private MusicalDetailRepository musicalDetailRepository;

        @Autowired
        private MusicalListRepository musicalListRepository;

        private String key = "5a64fe18bbc04f6aaedbedbe0e9dfa13";

        ObjectMapper mapper = new ObjectMapper();

        @GetMapping("/{mt20id}")
        public Map<String, Object> MusicalDetail(@PathVariable("mt20id") String var) {

                Map<String, Object> map = new HashMap<>();
                Map<String, Object> map2;

                try {
                        UriComponents uri = UriComponentsBuilder
                                .fromUriString("https://www.kopis.or.kr")
                                .path("/openApi/restful/pblprfr/")
                                .path("PF202217") // 뮤지컬 id (임시 : 베토벤 id)
                                .queryParam("service", key) // 인증키
                                .encode() // utf-8 로 인코딩
                                .build();

                        RestTemplate restTemplate = new RestTemplate();
                        String response = restTemplate.getForObject(uri.toUri(), String.class);

                        JSONObject jsonObj1 = XML.toJSONObject(response);

                        JSONObject jsonObj2 = (JSONObject) jsonObj1.get("dbs");
                        JSONObject jsonObj3 = (JSONObject) jsonObj2.get("db");
                        JSONObject jsonObj4 = (JSONObject) jsonObj3.get("styurls");

                        String jsonString = jsonObj3.toString();
                        String jsonString2 = jsonObj4.toString();

                        map = mapper.readValue(jsonString, Map.class);
                        map2 = mapper.readValue(jsonString2, Map.class);

                        log.warn("공연출연진: " + map.get("prfcast"));
                        log.warn("공연명: " + map.get("prfnm"));
                        log.warn("포스터: " + map.get("poster"));
                        log.warn("상세이미지: " + map2.get("styurl"));





//                        JSONParser jsonParser = new JSONParser();
//                        JSONObject jsonParseObj = (JSONObject) jsonParser.parse(jsonObj1.toString());
//
//                        JSONObject jsonObj2 = (JSONObject) jsonParseObj.get("dbs");
//                        jsonObj3 = (JSONObject) jsonObj2.get("db");

//                        log.warn(jsonObj1.toString());

//                        // db에 저장
//                        for (int i = 0; i < jsonObj3.size(); i++) {
//                                JSONObject tmp = (JSONObject) jsonObj3.get(i);
//                                MusicalDetailDTO detailDTO = new MusicalDetailDTO(
//                                        (String) tmp.get("prfcast"), (String) tmp.get("prfcrew"),
//                                        (String) tmp.get("dtguidance"));
//                                musicalDetailRepository.save(detailDTO);
//                        }


                } catch (Exception e) {
                        e.printStackTrace();
                }
                return map;
        }
}
