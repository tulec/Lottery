package com.test.lottery.service;

import com.test.lottery.model.Participant;
import com.test.lottery.repository.ParticipantRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LotteryService {

    private final ParticipantRepository participantRepository;
    private final RandUtils randUtils;

    public LotteryService(ParticipantRepository participantRepository, RandUtils randUtils) {
        this.participantRepository = participantRepository;
        this.randUtils = randUtils;
    }

    @Transactional
    public Participant decideWinner() {
        List<Participant> participants = participantRepository.findAll();
        if (participants.size() < 2) {
            return null;
        }
        Integer winnerId = randUtils.getRandInt(participants.size());
        Participant winner = participants.get(winnerId);
        participantRepository.deleteAll();
        return winner;
    }

    public Integer decidePrize() {
        return randUtils.getRandInt(1000);
    }
}
