package com.codemain.webflux;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFlux {

    @Test
    public void testMono(){
        Mono<String> monoString = Mono.just("Pavan").log();
        monoString.subscribe(System.out::println);
    }

    @Test
    public void testFlux(){
        Flux<String> fluxString = Flux.just("pavan", "mane", "techi", "program")
                .concatWith(Flux.error(new RuntimeException("exception occured in flux")))
                .concatWithValues("goal").log();
        fluxString.subscribe();
    }

}
