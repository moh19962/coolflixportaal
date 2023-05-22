package com.coolflix.fraudchampion.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudChampionCheckHistory {
    @Id
    @SequenceGenerator(
            name = "fraudchampion_id_sequence",
            sequenceName = "fraudchampion_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraudchampion_id_sequence"
    )
    private Integer id;
    private Integer championId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;
}
