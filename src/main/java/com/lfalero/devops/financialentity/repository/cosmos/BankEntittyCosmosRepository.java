package com.lfalero.devops.financialentity.repository.cosmos;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.lfalero.devops.financialentity.model.entity.cosmos.BankEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BankEntittyCosmosRepository extends ReactiveCosmosRepository<BankEntity, String> {
}
