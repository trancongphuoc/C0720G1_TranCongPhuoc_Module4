package com.codegym.controller;


import com.codegym.entity.user.Role;
import com.codegym.entity.user.User;
import com.codegym.entity.user.UserRole;
import com.codegym.service.contract.ContractService;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.service.ServiceDao;
import com.codegym.service.user.RoleService;
import com.codegym.service.user.UserRoleService;
import com.codegym.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    ServiceDao serviceDao;

    @Autowired
    CustomerService customerService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ContractService contractService;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    @GetMapping("/service/list")
    public String goListService(Model model, @PageableDefault(size = 10)Pageable pageable) {
        model.addAttribute("serviceList",serviceDao.findAll(pageable));
        return "view/manage/service-list";
    }



    @GetMapping("/customer/list")
    public String goListCustomer(Model model, @PageableDefault(size = 10)Pageable pageable) {
        model.addAttribute("customerList",customerService.findAll(pageable));
        return "view/manage/customer-list";
    }


    @GetMapping("/employee/list")
    public String goListEmployee(Model model, @PageableDefault(size = 10)Pageable pageable) {
        model.addAttribute("employeeList",employeeService.findAll(pageable));
        return "view/manage/employee-list";
    }


    @GetMapping("/contract/list")
    public String goListContract(Model model, @PageableDefault(size = 10)Pageable pageable) {
        model.addAttribute("contractList",contractService.findAll(pageable));
        return "view/manage/contract-list";
    }


    @GetMapping("/user/list")
    public String goListUser(Model model, @PageableDefault(size = 10)Pageable pageable) {
        model.addAttribute("userList",userService.findAll(pageable));
        model.addAttribute("roleList", roleService.findAll());
        return "view/manage/user-list";
    }


    @GetMapping("/contract/detail/{idContract}")
    public String goDetailContract(@PathVariable Long idContract, Model model) {
        model.addAttribute("contract",contractService.findById(idContract));
        return "view/manage/contract-detail";
    }


    @PostMapping("/user/update-role")
    public String updateRole(@RequestParam Long roleId,
                             @RequestParam Long userId) {

        User user = userService.findById(userId);
        Role role = roleService.findById(roleId);
        UserRole userRole = new UserRole();

        userRole.setUser(user);
        userRole.setRole(role);

        userRoleService.save(userRole);

        return "redirect:/manage/user/list";
    }

}
