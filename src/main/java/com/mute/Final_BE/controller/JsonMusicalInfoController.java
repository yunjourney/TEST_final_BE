package com.mute.Final_BE.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.parser.JSONParser;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/jsonapi")
public class JsonMusicalInfoController {

//    @GetMapping("/detail")
    private String key="5a64fe18bbc04f6aaedbedbe0e9dfa13";
    private String mt20id="PF202217";

//    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/musical")
    public Object MusicalDetail(HttpServletResponse response) throws IOException {

        //HttpHeaders headers = new HttpHeaders(); // 헤더가 있어야 json으로 인식해서 외부처리가능
        UriComponents uri = UriComponentsBuilder
                .fromUriString("https://www.kopis.or.kr")
                .path("/openApi/resftul/pblprfr/")
                .path(mt20id) // 뮤지컬 id (임시 : 베토벤 id)
                .queryParam("service", key) // 인증키
                .encode() // utf-8 로 인코딩
                .build();

        RestTemplate restTemplate = new RestTemplate();

        JSONObject jsonObject = XML.toJSONObject(uri.toString()); // xml 데이터를 json 데이터로 변환

        JSONParser parser = new JSONParser(); // json을 파싱하여 원하는 값만 가져오려고
//        JSONObject object = (JSONObject) parser.parse(jsonObject);





        //jsonPrintString = jsonObject.toString(); // string 형식으로 불러짐

//       response.sendRedirect(uri.toString());
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");




//        //헤더를 넣기 위한 것
//        RequestEntity<Void> req = RequestEntity
//                .get(uri.toUri())
//                .header("")
//                .build();
//
//        ResponseEntity<String> result = restTemplate.exchange(req, String.class);

        return uri.toUriString();
    }
}
