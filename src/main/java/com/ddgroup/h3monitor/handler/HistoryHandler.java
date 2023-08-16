package com.ddgroup.h3monitor.handler;

import com.ddgroup.h3monitor.model.entity.History;
import com.ddgroup.h3monitor.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoryHandler {
    private static final Long ID = 1L;
    private final HistoryRepository historyRepository;

    public History getHistory() {
        return historyRepository.findById(ID).orElseThrow();
    }

    public void updateHistory(History history) {
        historyRepository.save(history);
    }
}
