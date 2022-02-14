package com.codemain.webflux.controller;

import com.codemain.webflux.dao.CustomerDao;
import com.codemain.webflux.model.CustomerDto;
import com.codemain.webflux.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService custService;

    @GetMapping(path = "/get-customers")
    public List<CustomerDto> getAllCustomers(){
       return custService.getCustomers();
    }

    @GetMapping(path = "/get-customers-stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<CustomerDto> getCustomer(){
        return custService.getFluxCustomers();
    }
}
