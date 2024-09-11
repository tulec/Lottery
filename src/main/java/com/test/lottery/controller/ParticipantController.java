package com.test.lottery.controller;

import com.test.lottery.model.Participant;
import com.test.lottery.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ParticipantController {

    @Autowired
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService){
        this.participantService = participantService;
    }

    @PostMapping("/lottery/participant")
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant participant){
        participantService.saveParticipant(participant);
        return ResponseEntity.ok(participant);
    }

    @GetMapping(value = "/lottery/participant")
    public ResponseEntity<List<Participant>> findAll(){
        List<Participant> participants = participantService.findAll();
        return ResponseEntity.ok(participants);
    }

}
