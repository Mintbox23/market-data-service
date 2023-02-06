package com.example.marketdataservice.yahoofinance.models.quote;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class QuoteResponse {
    ArrayList<Result> result;
    Object error;
}
