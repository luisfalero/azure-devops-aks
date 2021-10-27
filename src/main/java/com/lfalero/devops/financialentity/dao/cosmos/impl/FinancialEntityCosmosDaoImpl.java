package com.lfalero.devops.financialentity.dao.cosmos.impl;


import com.lfalero.devops.financialentity.dao.cosmos.FinancialEntityCosmosDao;
import com.lfalero.devops.financialentity.model.api.FinancialEntityResponse;
import com.lfalero.devops.financialentity.repository.cosmos.BankEntittyCosmosRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Slf4j
@Component
@AllArgsConstructor
public class FinancialEntityCosmosDaoImpl implements FinancialEntityCosmosDao {

    private final BankEntittyCosmosRepository repository;

    @Override
    public Flux<FinancialEntityResponse> findAllBankEntities() {
        Flux<FinancialEntityResponse> response = repository
                .findAll()
                .flatMap(element -> {
                    FinancialEntityResponse entity = new FinancialEntityResponse();
                    BeanUtils.copyProperties(element, entity);
                    entity.setFinancialEntityId(element.getId());
                    return Mono.just(entity);
                });
        response.subscribe(element -> log.info(element.toString()));
        return response;
    }
}
