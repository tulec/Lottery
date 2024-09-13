package com.test.lottery.controller;

import com.test.lottery.model.Winner;
import com.test.lottery.service.WinnerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class WinnerController {

    private final WinnerService winnerService;

    public WinnerController(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @GetMapping("/winners")
    public ResponseEntity<List<Winner>> findAll() {
        List<Winner> winners = winnerService.findAll();
        return ResponseEntity.ok(winners);
    }
}
