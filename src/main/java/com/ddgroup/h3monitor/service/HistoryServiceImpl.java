package com.ddgroup.h3monitor.service;

import com.ddgroup.h3monitor.handler.HistoryHandler;
import com.ddgroup.h3monitor.model.dto.*;
import com.ddgroup.h3monitor.model.entity.History;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final HistoryHandler handler;
    private final ObjectMapper objectMapper;

    @Override
    public List<Match> getMatchesHistory() {
        History history = handler.getHistory();
        return readMatches(history.getMatches())
            .stream()
            .sorted((o1, o2) -> {
                LocalDateTime o1Time = LocalDateTime.from(formatter.parse(o1.dateTime()));
                LocalDateTime o2Time = LocalDateTime.from(formatter.parse(o2.dateTime()));
                return o1Time.compareTo(o2Time);
            })
            .toList();
    }

    @Override
    public void addMatchToHistory(Match match) {
        History history = handler.getHistory();
        List<Match> matchesHistory = new ArrayList<>(readMatches(history.getMatches()));
        matchesHistory.add(match);
        String parsedMatches = writeMatches(matchesHistory);
        history.setMatches(parsedMatches);
        handler.updateHistory(history);
    }

    @Override
    public Statistics getStatistics() {
        History history = handler.getHistory();
        return new Statistics(history.getPlayerOneSetPoints(),
            history.getPlayerOneMatchPoints(),
            history.getPlayerTwoSetPoints(),
            history.getPlayerTwoMatchPoints());
    }

    @Override
    public void updateStatistics(Statistics statistics) {
        History history = handler.getHistory();
        history.setPlayerOneSetPoints(statistics.playerOneSetPoints());
        history.setPlayerOneMatchPoints(statistics.playerOneMatchPoints());
        history.setPlayerTwoSetPoints(statistics.playerTwoSetPoints());
        history.setPlayerTwoMatchPoints(statistics.playerTwoMatchPoints());
        handler.updateHistory(history);
    }

    private String writeMatches(List<Match> matches) {
        try {
            return objectMapper.writeValueAsString(matches);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Match> readMatches(String json) {
        try {
            return objectMapper.readValue(json, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
