package com.codemain.webflux.service;

import com.codemain.webflux.dao.CustomerDao;
import com.codemain.webflux.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao custDao;

    public List<CustomerDto> getCustomers(){
        return custDao.getCustomers();
    }

    public Flux<CustomerDto> getFluxCustomers(){
        return custDao.getFluxCustomers();
    }
}
