package com.test.lottery.controller;


import com.test.lottery.model.Winner;
import com.test.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LotteryController {

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    private final LotteryService lotteryService;

    @GetMapping("/lottery/start")
    public ResponseEntity<?> startLottery() {
        Winner winner = lotteryService.decideWinner();
        if(winner == null)
            return new ResponseEntity<>("Not enough participants to start the lottery", HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok(winner);
    }

}
