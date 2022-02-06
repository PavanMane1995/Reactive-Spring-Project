package com.codemain.webflux.service;

import com.codemain.webflux.dao.CustomerDao;
import com.codemain.webflux.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao custDao;

    public List<CustomerDto> getCustomers(){
        return custDao.getCustomers();
    }
}
