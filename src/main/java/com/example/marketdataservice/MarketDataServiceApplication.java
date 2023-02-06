package com.example.marketdataservice;

import com.example.marketdataservice.yahoofinance.models.forexpros.ForexprosData;
import com.example.marketdataservice.yahoofinance.service.AlgoService;
import com.example.marketdataservice.yahoofinance.service.SchedulerService;
import com.example.marketdataservice.yahoofinance.service.runnable.TNXRunnable;
import com.example.marketdataservice.yahoofinance.service.webclient.YahooDataService;
import com.example.marketdataservice.yahoofinance.service.runnable.ABXRunnable;
import com.example.marketdataservice.yahoofinance.service.runnable.GFRunnable;
import com.example.marketdataservice.yahoofinance.service.runnable.NARunnable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

@SpringBootApplication
public class MarketDataServiceApplication {

    public static void main(String[] args) throws InterruptedException, JsonProcessingException {
        SpringApplication.run(MarketDataServiceApplication.class, args);

        YahooDataService yahooDataService = new YahooDataService();

        SchedulerService schedulerService = new SchedulerService(
                new ABXRunnable(new AlgoService(new YahooDataService())),
                new NARunnable(new AlgoService(new YahooDataService())),
                new GFRunnable(new AlgoService(new YahooDataService())),
                new TNXRunnable(new AlgoService(new YahooDataService()))
        );

        String message = "[\"{\\\"_event\\\":\\\"bulk-subscribe\\\",\\\"tzID\\\":8,\\\"message\\\":\\\"pid-0:%%pid-25273:%%isOpenExch-51:%%pid-25275:%%pid-25277:%%pid-23701:%%isOpenExch-1:%%pid-23705:%%pid-23706:%%pid-23693:%%isOpenExch-4:%%pid-8849:%%isOpenExch-1004:%%pid-8833:%%pid-8862:%%pid-8830:%%pid-8836:%%pid-8916:%%pid-8851:%%isOpenExch-127:%%isOpenExch-108:%%isOpenExch-109:%%pid-6408:%%isOpenExch-2:%%pid-6369:%%pid-243:%%pid-267:%%pid-7888:%%pid-284:%%isOpenExch-3:%%pid-352:%%pid-24441:%%pid-25282:%%pid-1175152:%%isOpenExch-152:%%pid-1175153:%%pid-44336:%%isOpenExch-97:%%pid-172:%%pid-8827:%%pid-1:%%isOpenExch-1002:%%pid-2:%%pid-3:%%pid-5:%%pid-7:%%pid-9:%%pid-10:%%pid-24467:%%pid-39124:%%pid-24698:%%pid-24523:%%pid-941155:%%pid-44334:%%pid-169:%%pid-20:%%pid-166:%%pid-27:%%pid-167:%%isOpenExch-9:%%pid-178:%%isOpenExch-20:%%pid-8831:%%pid-8832:%%pid-9227:%%pid-38181:%%pid-40655:%%pid-40687:%%pid-14195:%%pidExt-8830:%%cmt-68-5-8830:\\\"}\"]";
        String message_gf_tnx = "[\"{\\\"_event\\\":\\\"bulk-subscribe\\\",\\\"tzID\\\":8,\\\"message\\\":\\\"pid-8830:%%pid-23705:\\\"}\"]";
        String message_tnx = "[\"{\\\"_event\\\":\\\"bulk-subscribe\\\",\\\"tzID\\\":8,\\\"message\\\":\\\"pid-23705:\\\"}\"]";


        /*WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(
            URI.create("wss://streaming.forexpros.com/echo/095/kadjtz6g/websocket"),
                session -> session.send(Mono.just(session.textMessage("[\"{\\\"_event\\\":\\\"bulk-subscribe\\\",\\\"tzID\\\":8,\\\"message\\\":\\\"pid-0:%%pid-25273:%%isOpenExch-51:%%pid-25275:%%pid-25277:%%pid-23701:%%isOpenExch-1:%%pid-23705:%%pid-23706:%%pid-23693:%%isOpenExch-4:%%pid-8849:%%isOpenExch-1004:%%pid-8833:%%pid-8862:%%pid-8830:%%pid-8836:%%pid-8916:%%pid-8851:%%isOpenExch-127:%%isOpenExch-108:%%isOpenExch-109:%%pid-6408:%%isOpenExch-2:%%pid-6369:%%pid-243:%%pid-267:%%pid-7888:%%pid-284:%%isOpenExch-3:%%pid-352:%%pid-24441:%%pid-25282:%%pid-1175152:%%isOpenExch-152:%%pid-1175153:%%pid-44336:%%isOpenExch-97:%%pid-172:%%pid-8827:%%pid-1:%%isOpenExch-1002:%%pid-2:%%pid-3:%%pid-5:%%pid-7:%%pid-9:%%pid-10:%%pid-24467:%%pid-39124:%%pid-24698:%%pid-24523:%%pid-941155:%%pid-44334:%%pid-169:%%pid-20:%%pid-166:%%pid-27:%%pid-167:%%isOpenExch-9:%%pid-178:%%isOpenExch-20:%%pid-8831:%%pid-8832:%%pid-9227:%%pid-38181:%%pid-40655:%%pid-40687:%%pid-14195:%%pidExt-8830:%%cmt-68-5-8830:\\\"}\"]")))
                    .thenMany(session.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                            .log()
                    ).then()
        ).block();*/

        WebSocketClient client = new ReactorNettyWebSocketClient();
        client.execute(
                URI.create("wss://streaming.forexpros.com/echo/095/kadjtz6g/websocket"),

                session -> session.send(Mono.just(session.textMessage(message_gf_tnx)))
                        // thenMany permet au mono de la fonction send() de completer avant d'executer le reste.
                        .thenMany(session.receive()
                                .map(webSocketMessage -> {
                                    String textMessage = webSocketMessage.getPayloadAsText();
                                    if (textMessage.length() > 1) {
                                        textMessage = textMessage.replaceAll("\\\\", "" )
                                                .replaceAll("::", "|");
                                        textMessage = textMessage.substring(textMessage.indexOf("|") + 1);
                                        textMessage = textMessage.substring(0, textMessage.length() - 4);
                                        ObjectMapper mapper = new ObjectMapper();
                                        try {
                                            ForexprosData forexprosData = mapper.readValue(textMessage, ForexprosData.class);
                                            System.out.println(forexprosData.getLast());
                                        } catch (JsonProcessingException e) {
                                            e.printStackTrace();
                                        }

                                        //System.out.println(textMessage);
                                        /*try {
                                            ForexprosData forexprosData = mapper.readValue(textMessage, ForexprosData.class);
                                            System.out.println(forexprosData.getLast());
                                        } catch (JsonProcessingException e) {
                                            e.printStackTrace();
                                        }*/

                                    }
                                    return webSocketMessage.getPayloadAsText();
                                })
                        ).then()
        ).subscribe();



        //schedulerService.startDataFetchingABX();
        //schedulerService.startSchedulerGF();

        /*yahooDataService.getYahooQuote5Proxy().subscribe(data -> {
            System.out.print("Proxy duration in ms : ");
            System.out.println(data.getT2());
            System.out.print("Proxy : ");
            System.out.println(data.getT1());
        });*/

        /*yahooDataService.getYahooQuoteList().subscribe(data -> {
            System.out.print("No proxy 5 quotes duration in ms : ");
            System.out.println(data.getT2());
            System.out.print("No proxy 5 quotes : ");
            System.out.println(data.getT1());
        });*/


        /*for (int i = 0; true; i++) {
            yahooDataService.getYahooQuoteASX().subscribe(data -> {
                System.out.println("getFinancialData : " + data.getQuoteSummary().getResult().get(0).getFinancialData().getCurrentPrice().getRaw());

            });
            yahooDataService.getYahooQuoteList().subscribe(data -> {
                //System.out.println("Bid : " + data.getT1().getQuoteResponse().getResult().get(0).getBid());
                //System.out.println("Ask : " + data.getT1().getQuoteResponse().getResult().get(0).getAsk());
                System.out.println("RegularMarketPrice : " + data.getT1().getQuoteResponse().getResult().get(0).getRegularMarketPrice());
            });
            Thread.sleep(1000);
        }*/

    }

}
