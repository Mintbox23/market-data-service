package com.example.marketdataservice.yahoofinance.models.defaultKeyStatistics;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class QuoteSummary {
    ArrayList<Result> result;
    Object error;
}
