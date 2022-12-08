package com.mute.Final_BE.controller;

import com.mute.Final_BE.dto.MusicalListDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


import com.mute.Final_BE.repository.MusicalDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.XML;
import org.json.simple.parser.JSONParser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@Slf4j
@RequestMapping("/json")
public class MusicalDetailController {

        @Autowired
        private MusicalDetailRepository musicalDetailRepository;

        private String key = "5a64fe18bbc04f6aaedbedbe0e9dfa13";

        @GetMapping("/{mt20id}")
        public String MusicalDetail(@PathVariable("mt20id") String var) {

                JSONObject jsonObj3 = null;
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

                        org.json.JSONObject jsonObj1 = XML.toJSONObject(response);

                        JSONParser jsonParser = new JSONParser();
                        JSONObject jsonParseObj = (JSONObject) jsonParser.parse(jsonObj1.toString());

                        JSONObject jsonObj2 = (JSONObject) jsonParseObj.get("dbs");
                        jsonObj3 = (JSONObject) jsonObj2.get("db");

                        log.warn(jsonObj3.toJSONString());

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
                return jsonObj3.toString();
        }
}
