package com.mute.Final_BE.controller;

import com.mute.Final_BE.service.MusicalListService;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
@RequestMapping("/jsonapi")
public class TestMusicalInfoController {

    // service 로직 연결
    private final MusicalListService musicalListService;
    public TestMusicalInfoController(MusicalListService musicalListService) {
        this.musicalListService = musicalListService;
    }

//    @PostMapping("/list")
//    public void musicalList(@RequestBody ) {
//
//    }






//
//    @GetMapping("/apitest")
//    public String callApiWithXml() {
//        StringBuffer result = new StringBuffer();
//        try {
//            String apiUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr" +
//                    "/PF202217" +
//                    "?service=5a64fe18bbc04f6aaedbedbe0e9dfa13";
//            URL url = new URL(apiUrl);
//            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//            urlConnection.setRequestMethod("GET");
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
//
//            String returnLine;
//            result.append("<xmp>");
//            while((returnLine = bufferedReader.readLine()) != null) {
//                result.append(returnLine + "\n");
//            }
//            urlConnection.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result + "</xmp>";
//    }
}
