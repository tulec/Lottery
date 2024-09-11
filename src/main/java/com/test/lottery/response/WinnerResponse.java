package com.test.lottery.response;

import com.test.lottery.model.Participant;
import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class WinnerResponse {

    public Participant participantWin;

    public Integer prizeAmount;

    public WinnerResponse(){}

    public WinnerResponse (Participant participant, Integer prize){
        participantWin = participant;
        prizeAmount = prize;
    }

}
