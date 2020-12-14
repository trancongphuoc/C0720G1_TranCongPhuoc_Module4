package com.codegym.service.implement.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    ContractRepository contractRepository;

    @Override
    public Contract findByCode(String code) {
        return contractRepository.findByCode(code);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
