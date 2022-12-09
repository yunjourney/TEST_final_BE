package com.mute.Final_BE.controller;

import com.mute.Final_BE.dto.MusicalDTO;
import com.mute.Final_BE.service.MuInfoService;
import com.mute.Final_BE.service.MusicalApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController // JSON으로 응답함을 선언
@RequiredArgsConstructor // final로 선언된 클래스 자동생성
public class MusicalController {

    private final MusicalApiService musicalApiService;

    @GetMapping("/api/list")
    public List<MusicalDTO> getMusicalList() {
        String resultString = musicalApiService.MusicalListApi();
        return musicalApiService.fromJSONtoItems(resultString);
    }

}
