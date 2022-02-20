package com.codemain.webflux.handler;

import com.codemain.webflux.dao.CustomerDao;
import com.codemain.webflux.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

    @Autowired
    private CustomerDao customerDao;

    public Mono<ServerResponse> getCustomers(ServerRequest serverRequest){
        Flux<CustomerDto> customerList = customerDao.getFluxCustomers();
        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customerList, CustomerDto.class);
    }

    public Mono<ServerResponse> getOneCustomer(ServerRequest serverRequest){
        Integer customerId = Integer.parseInt(serverRequest.pathVariable("input"));
        Mono<CustomerDto> cust =customerDao.getFluxCustomers().filter(a -> a.getId() == customerId).next();
        return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(cust, CustomerDto.class);
    }
}
