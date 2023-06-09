package com.coolflix.feed.Domain.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Feed {

    @Id
    @SequenceGenerator(
            name = "feed_id_sequence",
            sequenceName = "feed_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "feed_id_sequence"
    )

    private Integer id;
    private Integer customerId;
    private String title;
    private String description;
    private LocalDateTime date;
}
