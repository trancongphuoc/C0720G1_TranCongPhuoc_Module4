package com.codegym.service.implement.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.repository.customer.CustomerTypeRepository;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerTypeRepository customerTypeRepository;


    @Override
    public Customer findByIdCard(String idCard) {
        return customerRepository.findByIdCard(idCard);
    }

    @Override
    public Customer findByPhoneNumber(String phone) {
        return customerRepository.findByPhone(phone);
    }

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public void save(Customer customer) {
        if (customer.getCustomerType() == null) {
            customer.setCustomerType(customerTypeRepository.findById((long) 1).get());
        }

        customerRepository.save(customer);
    }

    @Override
    public Customer findByCode(String code) {
        return customerRepository.findByCode(code);
    }
}
