package com.test.lottery.controller;

import com.test.lottery.model.Participant;
import com.test.lottery.model.Winner;
import com.test.lottery.service.LotteryService;
import com.test.lottery.service.WinnerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
    private final LotteryService lotteryService;
    private final WinnerService winnerService;

    public LotteryController(LotteryService lotteryService, WinnerService winnerService) {
        this.lotteryService = lotteryService;
        this.winnerService = winnerService;
    }

    @GetMapping("/start")
    public ResponseEntity<?> startLottery() {
        Participant participant = lotteryService.decideWinner();
        if (participant == null) {
            return new ResponseEntity<>("Not enough participants to start the lottery", HttpStatus.BAD_REQUEST);
        } else {
            Integer prize = lotteryService.decidePrize();
            Winner winner = Winner.builder()
                    .name(participant.getName())
                    .prizeAmount(prize)
                    .build();
            winnerService.saveWinner(winner);

            Map<String, Object> response = new HashMap<>();
            response.put("name", participant.getName());
            response.put("prize_amount", prize);

            return ResponseEntity.ok(response);
        }
    }
}
