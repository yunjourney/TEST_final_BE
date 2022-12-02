//import com.mute.Final_BE.dto.MusicalInfoDTO;
//import com.mute.Final_BE.repository.MusicalDetailRepository;
//import lombok.RequiredArgsConstructor;
//import org.json.XML;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.URL;
//
//@RestController
//@RequiredArgsConstructor
//public class exApiRestController {
//
//    @Autowired
//    private MusicalDetailRepository detailRepository;
//
//    @GetMapping("/api")
//    public String index(){
//        return "index";
//    }
//
//    @PostMapping("/api")
//    public String load_save(@RequestParam("date") String date, Model model){
//        String result = "";
//
//        try {
//            String requestDate=date;
//            URL url = new URL("http://openapi.seoul.go.kr:8088/" + "받은인증키/" +
//                    "json/CardSubwayStatsNew/1/700/"+requestDate);
//            BufferedReader bf;
//            bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
//            result = bf.readLine();
//
//            //org.json.JSONObject jsonObject = XML.toJSONObject(result.toString());
//
//            JSONParser jsonParser = new JSONParser();
//            org.json.JSONObject jsonObject = XML.toJSONObject(result.toString());
//
//            JSONObject CardSubwayStatsNew = (JSONObject)jsonObject.get("CardSubwayStatsNew");
//            Long totalCount=(Long)CardSubwayStatsNew.get("list_total_count");
//
//            JSONObject subResult = (JSONObject)CardSubwayStatsNew.get("RESULT");
//            JSONArray infoArr = (JSONArray) CardSubwayStatsNew.get("row");
//
////            for(int i=0;i<infoArr.size();i++){
////                JSONObject tmp = (JSONObject)infoArr.get(i);
////                MusicalInfoDTO infoObj=new MusicalInfoDTO(i+(long)1, (String)tmp.get("mt20id"),(String)tmp.get("prfnm"),(String)tmp.get("prfpdfrom"),
////                        (String)tmp.get("prfpdto"), (String)tmp.get("fcltynm"),(String)tmp.get("prfcast"));
////            }
//
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        return "redirect:/findname";
//    }
//}