package com.test.lottery.service;


import com.test.lottery.model.Winner;
import com.test.lottery.model.Participant;
import com.test.lottery.repository.ParticipantRepository;
import com.test.lottery.repository.WinnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LotteryService {

    private final ParticipantRepository participantRepository;
    private final WinnerRepository winnerRepository;

    public LotteryService(ParticipantRepository participantRepository, WinnerRepository winnerRepository) {
        this.participantRepository = participantRepository;
        this.winnerRepository = winnerRepository;
    }

    public Winner decideWinner() {
        List<Participant> participants = participantRepository.findAll();
        int numOfParticipants = participants.size();
        if (numOfParticipants < 2)
        {
            return null;
        }
        else
        {
            int prizeAmount = RandUtils.getRandInt(1000);
            int winnerId = RandUtils.getRandInt(numOfParticipants - 1);
            String participantName = participants.get(winnerId).getName();
            Winner winner = Winner.builder().name(participantName).prize_amount(prizeAmount).build();
            winnerRepository.save(winner);
            participantRepository.deleteAll();
            return winner;
        }
    }

}
