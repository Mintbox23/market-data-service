package com.example.marketdataservice.yahoofinance.models.options;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class OptionChain {
    ArrayList<Result> result;
}
