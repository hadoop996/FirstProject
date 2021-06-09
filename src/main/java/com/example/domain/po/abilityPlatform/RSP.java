package com.example.domain.po.abilityPlatform;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@Data
public class RSP {
    private String RSP_CODE;
    private String RSP_DESC;
    private String SUB_CODE;
    private String SUB_DESC;
    private List<DATA> DATA;
}
