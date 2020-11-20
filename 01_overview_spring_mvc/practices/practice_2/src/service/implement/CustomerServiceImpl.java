package service.implement;

import model.Customer;
import org.springframework.stereotype.Service;
import service.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static Map<Integer, Customer> customerList = new HashMap<>();

    static {
        customerList.put(0, new Customer(0, "T", "t@codegym.vn","Da Nang"));
        customerList.put(1, new Customer(1, "Nhat", "nhat@codegym.vn","Quang Tri"));
        customerList.put(2, new Customer(2, "Trang", "trang@codegym.vn","Ha Noi"));
        customerList.put(3, new Customer(3, "Nguyen Binh Son", "son@codegym.vn","Sai Gon"));
        customerList.put(4, new Customer(4, "Dang Xuan Hoa", "hoa@codegym.vn","Da Nang"));
    }

    @Override
    public Map<Integer, Customer> findAllCustomer() {
        return customerList;
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerList.get(id);
    }
}
