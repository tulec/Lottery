package com.test.lottery.controller;


import com.test.lottery.model.Participant;
import com.test.lottery.model.Winner;
import com.test.lottery.response.WinnerResponse;
import com.test.lottery.service.LotteryService;

import com.test.lottery.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LotteryController {



    @Autowired
    public LotteryController(LotteryService lotteryService, WinnerService winnerService) {
        this.lotteryService = lotteryService;
        this.winnerService = winnerService;
    }

    private final LotteryService lotteryService;
    private final WinnerService winnerService;

    @GetMapping("/lottery/start")
    public ResponseEntity<?> startLottery() {
        Participant participant = lotteryService.decideWinner();
        if(participant == null)
            return new ResponseEntity<>("Not enough participants to start the lottery", HttpStatus.BAD_REQUEST);
        else {
            Integer prize = lotteryService.decidePrize();
            Winner winner = Winner.builder().name(participant.getName()).prize_amount(prize).build();
            winnerService.saveWinner(winner);

            WinnerResponse winnerResponse = new WinnerResponse(participant, prize);
            return ResponseEntity.ok(winnerResponse);
        }
    }

}
