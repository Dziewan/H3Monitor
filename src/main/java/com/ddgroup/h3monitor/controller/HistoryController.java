package com.ddgroup.h3monitor.controller;

import com.ddgroup.h3monitor.model.dto.*;
import com.ddgroup.h3monitor.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/history")
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public List<Match> getMatchesHistory() {
        return historyService.getMatchesHistory();
    }

    @PostMapping("/match")
    public void addMatchToHistory(@RequestBody Match match) {
        historyService.addMatchToHistory(match);
    }

    @GetMapping("/statistics")
    public Statistics getStatistics() {
        return historyService.getStatistics();
    }

    @PutMapping("/statistics")
    public void updateStatistics(@RequestBody Statistics statistics) {
        historyService.updateStatistics(statistics);
    }
}
