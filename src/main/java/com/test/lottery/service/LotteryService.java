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

    public Participant decideWinner() {
        List<Participant> participants = participantRepository.findAll();
        int numOfParticipants = participants.size();
        if (numOfParticipants < 2)
        {
            return null;
        }
        else
        {
            Integer winnerId = RandUtils.getRandInt(numOfParticipants - 1);
            Participant winner = participants.get(winnerId);
            participantRepository.deleteAll();
            return winner;
        }
    }

    public Integer decidePrize()
    {
        return RandUtils.getRandInt(1000);
    }

}
