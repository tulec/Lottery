package com.test.lottery.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "winners")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "prize_amount")
    private Integer prizeAmount;
}
