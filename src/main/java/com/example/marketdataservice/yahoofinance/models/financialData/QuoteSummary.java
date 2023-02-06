package com.example.marketdataservice.yahoofinance.models.financialData;

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
