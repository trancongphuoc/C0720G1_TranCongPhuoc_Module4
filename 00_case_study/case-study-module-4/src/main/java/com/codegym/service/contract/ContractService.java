package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;

public interface ContractService {
    Contract findByCode(String code);

    void save(Contract contract);
}
