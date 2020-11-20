package service;

import model.Customer;


import java.util.Map;

public interface CustomerService {

    Map<Integer, Customer> findAllCustomer();

    Customer findCustomerById(int id);
}
