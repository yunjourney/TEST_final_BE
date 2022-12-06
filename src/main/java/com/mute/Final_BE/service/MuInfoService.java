package com.mute.Final_BE.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Slf4j
@Service
@RequiredArgsConstructor
public class MuInfoService {

//    private String url="http://www.kopis.or.kr/openApi/restful/pblprfr";
    private String key="5a64fe18bbc04f6aaedbedbe0e9dfa13";
    private String mt20id="PF202217";

    @GetMapping("/musical")
    public Object MusicalDetail() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders(); // 헤더가 있어야 json으로 인식해서 외부처리가능
        UriComponents builder = UriComponentsBuilder.newInstance() // uri 조합을 쉽게해줌
                .scheme("http")
                .host("www.kopis.or.kr")
                .path("/openApi/resftul/pblprfr")
                .queryParam("mt20id", mt20id) // 뮤지컬 id (임시 : 베토벤 id)
                .queryParam("service", key) // 인증키
                .encode()
                .build();

        ResponseEntity<String> result =
                restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);

        return result.getBody();

    }
}
