package com.p50x.animecharacter;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Character {
    @Id
    @SequenceGenerator(
            name="character_id_sequence",
            sequenceName = "character_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
    )
    private Long Id;

    private String name;

    private String series;

    private LocalDate createdDate;

}
