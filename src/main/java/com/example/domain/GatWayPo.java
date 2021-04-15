package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GatWayPo {

    private String telareacode;


    private  String provincecode;


    private  String citycode;

    private  String nettype;


    private  String  paytype;


    private  String usernumber;


}
