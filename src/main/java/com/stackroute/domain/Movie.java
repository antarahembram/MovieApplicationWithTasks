package com.stackroute.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity  // used for JPA repository
@Data // to generate getter and setter of the Movie class
@NoArgsConstructor  // to generate constructor with no arguments
@AllArgsConstructor   //to generate constructor with all arguments
@Builder
public class Movie {

    @Id //set movieId as primary key
    private int movieId=0;
    private String genre;
    private String movieTitle;
    private String language;
    private String status;
    private long voteCount;
    private BigDecimal budget;

}
