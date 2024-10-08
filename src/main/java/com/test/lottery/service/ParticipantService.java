package com.test.lottery.service;

import com.test.lottery.model.Participant;
import com.test.lottery.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    private final ParticipantRepository participantRepository;

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public void saveParticipant(Participant participant){
        participantRepository.save(participant);
    }




}
