package com.mute.Final_BE.controller;

import com.mute.Final_BE.dto.MusicalDTO;
import com.mute.Final_BE.dto.MusicalDetailDTO;
import com.mute.Final_BE.service.MuInfoService;
import com.mute.Final_BE.service.MusicalApiService;
import com.mute.Final_BE.service.MusicalDetailApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController // JSON으로 응답함을 선언
@RequiredArgsConstructor // final로 선언된 클래스 자동생성
public class MusicalController {

    private final MusicalApiService musicalApiService;
    private final MusicalDetailApiService musicalDetailApiService;

    @GetMapping("/musical/list")
    public List<MusicalDTO> getMusicalList() {
        String resultString = musicalApiService.MusicalListApi();
        return musicalApiService.fromJSONtoItems(resultString);
    }

    // 선택한 뮤지컬 상세정보 불러오기
    @GetMapping("/musical/{mt20id}")
    public List<MusicalDetailDTO> getMusicalDetail(@PathVariable String mt20id) {
        String result = musicalDetailApiService.MusicalDetailApi(mt20id);
        return musicalDetailApiService.getMapFromJsonObj(result);
    }

}
