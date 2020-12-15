package com.codegym.controller;


import com.codegym.entity.contract.Contract;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.Service;
import com.codegym.entity.user.Role;
import com.codegym.entity.user.User;
import com.codegym.entity.user.UserRole;
import com.codegym.service.contract.ContractService;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.employee.DivisionService;
import com.codegym.service.employee.EducationDegreeService;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.employee.PositionService;
import com.codegym.service.service.AttachServiceDao;
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
@SessionAttributes({"serviceTypeList"})
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

    @Autowired
    AttachServiceDao attachServiceDao;

    @Autowired
    PositionService positionService;

    @Autowired
    EducationDegreeService educationDegreeService;

    @Autowired
    DivisionService divisionService;

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
        model.addAttribute("positionList",positionService.findAll());
        model.addAttribute("educationDegreeList",educationDegreeService.findAll());
        model.addAttribute("divisionList",divisionService.findAll());

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


    @GetMapping("/attach-service/list")
    public String goListAttachService(Model model) {
        model.addAttribute("attachServiceList",attachServiceDao.findAll());
        return "view/manage/attach-service-list";
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


    @GetMapping("/contract/payment/{idContract}")
    public String payment(@PathVariable Long idContract) {
        Contract contract = contractService.findById(idContract);

        if (contract != null) {
            contract.setStatus(true);
            contractService.save(contract);

            Service service = serviceDao.findById(contract.getService().getId());
            service.setStatus(false);
            serviceDao.save(service);

        }
        return "redirect:/manage/contract/list";
    }



    // Update Employeeeeee
    @PostMapping("/employee/update")
    public String updateEmployee(@RequestParam Long epId,
                                 @RequestParam Long posId,
                                 @RequestParam Long eduId,
                                 @RequestParam Long divId) {
        Employee employee = employeeService.findById(epId);

        employee.setPosition(positionService.findById(posId));
        employee.setEducationDegree(educationDegreeService.findById(eduId));
        employee.setDivision(divisionService.findById(divId));

        employeeService.save(employee);

        return "redirect:/manage/employee/list";
    }




//     Delete Service
    @GetMapping("/service/delete/{id}")
    public String deleteServiceById(@PathVariable Long id) {
        serviceDao.deleteById(id);

        return "redirect:/manage/service/list";
    }


//     Delete Service
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployeeId(@PathVariable Long id) {
        employeeService.deleteById(id);

        return "redirect:/manage/employee/list";
    }

}
