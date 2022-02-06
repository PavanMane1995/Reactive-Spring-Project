package com.codemain.webflux.dao;

import com.codemain.webflux.model.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<CustomerDto> getCustomers(){
        return IntStream.rangeClosed(1, 20)
                .peek(System.out::println)
                .peek(CustomerDao::delay)
                .mapToObj(a -> new CustomerDto(a, "customer"+a))
                .collect(Collectors.toList());

    }

    private static void delay(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
