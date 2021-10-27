package com.lfalero.devops.financialentity.model.entity.cosmos;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Container(containerName = "banks")
public class BankEntity {

    @Id
    @GeneratedValue
    private String id;

    @PartitionKey
    private String code;

    private String fullName;
    private String shortName;
}
