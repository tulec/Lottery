package com.test.lottery.service;

import com.test.lottery.model.Winner;
import com.test.lottery.repository.WinnerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WinnerService {

    private final WinnerRepository winnerRepository;

    public WinnerService(WinnerRepository winnerRepository) {
        this.winnerRepository = winnerRepository;
    }

    public List<Winner> findAll() {
        return winnerRepository.findAll();
    }

    @Transactional
    public void saveWinner(Winner winner) {
        winnerRepository.save(winner);
    }
}
