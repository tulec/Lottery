package com.test.lottery.controller;

import com.test.lottery.model.Participant;
import com.test.lottery.service.ParticipantService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("/participant")
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant) {
        participantService.saveParticipant(participant);
        return ResponseEntity.ok(participant);
    }

    @GetMapping("/participant")
    public ResponseEntity<List<Participant>> findAll() {
        List<Participant> participants = participantService.findAll();
        return ResponseEntity.ok(participants);
    }
}
