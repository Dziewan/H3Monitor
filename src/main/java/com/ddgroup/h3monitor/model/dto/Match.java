package com.ddgroup.h3monitor.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Match(Player playerOne, Player playerTwo, boolean onGoing, Integer season, String dateTime) {
}
