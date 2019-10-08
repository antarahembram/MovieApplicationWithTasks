package com.stackroute.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private int movieId=0;
    private String genre;
    private String movieTitle;
    private String language;
    private String status;
    private long voteCount;
    private BigDecimal budget;

}
