//package com.mute.Final_BE.controller;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class examApiRestController {
//    @GetMapping(value = "/exam100.json")
//    public Map<String, Object> exam100GET() {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            // 소셜 로그인 , 공공api 등의 url
//            String url = "http://1.234.5.158:13000/xml/exam1.xml";
//
//            // Spring boot에서 제공하는 RestTemplate
//            RestTemplate restTemplate = new RestTemplate();
//
//            // 1. api호출하여 결과를 가져오기
//            // 대부분의 api는 get형태가 많다 = 정보를 가져오거나 받아오는 형태
//            // RestTemplate.getForObject(URI url, Class<T> responseType) => (호출하는 url, 반환타입)
//            String response = restTemplate.getForObject(url, String.class);
//
//            // XML을 JSON Object로 변환하기
//            JSONObject jobj = XML.toJSONObject(response);
//
//            // 변환된 데이터 확인
//            // {"response":{"items":{"item":[{"name":"one","id":1},{"name":"two","id":2},{"name":"three","id":3}]}}}
//            System.out.println("--------------jobj.toString---------------");
//            System.out.println(jobj.toString());
//
//            // 3. 데이터에서 꺼내어쓰기
//            JSONObject jobj1 = jobj.getJSONObject("response").getJSONObject("items");
//
//            // {"item":[{"name":"one","id":1},{"name":"two","id":2},{"name":"three","id":3}]}
//            System.out.println("--------------jobj1---------------");
//            System.out.println(jobj1.toString());
//
//            // 배열 형태이니 반복문을 이용
//            // [
//            // {"name":"one","id":1},
//            // {"name":"two","id":2},
//            // {"name":"three","id":3}
//            // ]
//
//            JSONArray jarr = jobj1.getJSONArray("item");
//            System.out.println(jarr.length());
//            for (int i = 1; i < jarr.length(); i++) {
//                // {"name":"one","id":1}
//                String name = jarr.getJSONObject(i).getString("name");
//                int id = jarr.getJSONObject(i).getInt("id");
//            }
//
//            System.out.println("--------------jarr---------------");
//            System.out.println(jarr);
//
//            // map.put("jobj", jobj.toString());
//
//            // String ret1 = jobj.getString("items"); //y
//            // String ret2 = jobj.getString("data"); //123
//
//            // System.out.println(ret1 + "," + ret2);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
//}
