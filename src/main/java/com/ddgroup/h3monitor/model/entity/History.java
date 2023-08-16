package com.ddgroup.h3monitor.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class History {

    @Id
    private Long id;
    private String matches;
    private Integer playerOneSetPoints;
    private Integer playerOneMatchPoints;
    private Integer playerTwoSetPoints;
    private Integer playerTwoMatchPoints;
}
