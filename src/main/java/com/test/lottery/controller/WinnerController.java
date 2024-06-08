package com.test.lottery.controller;


import com.test.lottery.model.Winner;
import com.test.lottery.service.WinnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class WinnerController {

    private final WinnerService winnerService;

    public WinnerController(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @GetMapping(value = "/lottery/winners")
    public ResponseEntity<List<Winner>> findAll(){
        List<Winner> winners = winnerService.findAll();
        return ResponseEntity.ok(winners);
    }
}
