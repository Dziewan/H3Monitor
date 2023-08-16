package com.ddgroup.h3monitor.service;

import com.ddgroup.h3monitor.model.dto.*;

import java.util.List;

public interface HistoryService {

    List<Match> getMatchesHistory();

    void addMatchToHistory(Match match);

    Statistics getStatistics();

    void updateStatistics(Statistics statistics);
}
