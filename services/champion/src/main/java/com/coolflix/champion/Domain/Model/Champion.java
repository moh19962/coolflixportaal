package com.coolflix.champion.Domain.Model;

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
public class Champion {
    @Id
    @SequenceGenerator(
            name = "champion_id_sequence",
            sequenceName = "champion_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "champion_id_sequence"
    )
    private Integer id;
    private String name;
    private String title;
    private String role;
    private String lore;
}
