package com.codemain.webflux;


import com.codemain.webflux.handler.CustomerHandler;
import com.codemain.webflux.model.CustomerDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;
import java.util.function.Function;

public class CustomerHandlerTest {

    @Autowired
    private CustomerHandler customerHandler;


}
