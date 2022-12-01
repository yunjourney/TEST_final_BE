package com.mute.Final_BE.controller;

import com.mute.Final_BE.service.MuInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/detail")
public class MuInfoController {
    private MuInfoService muInfoService;
    public MuInfoController(MuInfoService muInfoService) {
        this.muInfoService = muInfoService;
    }

//    @GetMapping("/{mt20id}")
//    public
}
