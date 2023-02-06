package com.example.marketdataservice.yahoofinance.models.forexpros;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ForexprosData {
    String pid;
    String last_dir;
    BigDecimal last_numeric;
    String last;
    String bid;
    String ask;
    String high;
    String low;
    String last_close;
    String pc;
    String pcp;
    String pc_col;
    String turnover;
    String turnover_numeric;
    String time;
    BigDecimal timestamp;
}
