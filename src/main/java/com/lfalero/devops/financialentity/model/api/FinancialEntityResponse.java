package com.lfalero.devops.financialentity.model.api;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FinancialEntityResponse {

    private String financialEntityId;
    private String code;
    private String fullName;
    private String shortName;
}
