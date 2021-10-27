package com.lfalero.devops.expose.web;

import com.lfalero.devops.financialentity.dao.cosmos.FinancialEntityCosmosDao;
import com.lfalero.devops.financialentity.model.api.FinancialEntityResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@Slf4j
@RestController
@RequestMapping("${application.api.path}")
@AllArgsConstructor
public class FinancialEntityController {

    private final FinancialEntityCosmosDao entity;

    @GetMapping(value = "/financial-entities")
    public Flux<FinancialEntityResponse> getFinancialEntities() {
        return entity.findAllBankEntities();
    }

    @GetMapping(value = "/health")
    public String health() {
        return "health";
    }
}
