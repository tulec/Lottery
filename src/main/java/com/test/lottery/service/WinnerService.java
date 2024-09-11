package com.test.lottery.service;

import com.test.lottery.model.Participant;
import com.test.lottery.model.Winner;
import com.test.lottery.repository.WinnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinnerService {

    public WinnerService(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    private final WinnerRepository winnerRepository;
    public List<Winner> findAll() {
        return winnerRepository.findAll();
    }

    public void saveWinner(Winner winner){ winnerRepository.save(winner);}


}
