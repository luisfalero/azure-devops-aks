package com.lfalero.devops.financialentity.dao.cosmos;

import com.lfalero.devops.financialentity.model.api.FinancialEntityResponse;
import reactor.core.publisher.Flux;

public interface FinancialEntityCosmosDao {

    Flux<FinancialEntityResponse> findAllBankEntities();
}
