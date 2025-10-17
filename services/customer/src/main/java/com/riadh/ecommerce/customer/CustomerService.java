package com.riadh.ecommerce.customer;

import com.riadh.ecommerce.exception.CustomerNotfoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor


public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;
    public String createCustomer( CustomerRequest request){
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequest request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotfoundException(
                        format("cannot update customer:: no customer found with the provided ID ::%s",request.id())
                ));

        mergeCustomer(customer,request);
        repository.save(customer);
    }
    private void mergeCustomer(Customer customer, CustomerRequest request){
        if(StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())){
            customer.setLastname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setEmail(request.email());
        }
        if(request.address() != null){
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {
        return repository.findById(customerId)
                .isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId).map(mapper::fromCustomer).orElseThrow(()-> new CustomerNotfoundException(format("No customer found with the provided ID ::%S", customerId)));
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
