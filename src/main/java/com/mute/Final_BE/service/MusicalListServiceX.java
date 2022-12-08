package com.mute.Final_BE.service;

//import com.mute.Final_BE.repository.MusicalListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@Slf4j
@RequiredArgsConstructor
public class MusicalListServiceX {

//    @Autowired
//    private MusicalListRepository musicalListRepository;

    @GetMapping("/list")
    public String MusicalList() {

        StringBuffer result = new StringBuffer();
        String jsonPrintString = null;


        try {
            String apiUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr" +
                    "?service=5a64fe18bbc04f6aaedbedbe0e9dfa13" +
                    "&stdate=20220901" +
                    "&edddate=20230301" +
                    "&cpage=1" + "&rows=20" + "&signgucode=11" + "&shcate=AAAB";
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream, "UTF-8"));
            String returnLine;
            while ((returnLine = bufferedReader.readLine()) != null) {
                result.append(returnLine);
            }

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject)jsonParser.parse(String.valueOf(XML.toJSONObject(result.toString()))); // xml 데이터를 json 데이터로 변환
            JSONObject dbs = (JSONObject)jsonObject.get("dbs");
            JSONArray dbArr = (JSONArray)dbs.get("db");
            for(int i = 0; i < dbArr.size(); i++) {
                jsonObject = (JSONObject) dbArr.get(i);
                String musicalName = (String) jsonObject.get("prfnm");
                String musicalId = (String) jsonObject.get("mt20id");
                String musicalStart = (String) jsonObject.get("prfpdfrom");
                String musicalEnd = (String) jsonObject.get("prfpdto");
                String theaterName = (String) jsonObject.get("fcltynm");
                String posterUrl = (String) jsonObject.get("poster");


            }


//            jsonPrintString = jsonObject.toString(); // string 형식으로 불러짐
//            JSONObject jsonObject1

        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonPrintString;
    }
}
