package com.example.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class CardBroadbandBO implements Serializable {
    private String installaddr;
    private String username;
    private String accesstype;
    private String fixedtele;
    private String flag;
    private String brandspeed;
    private String installdate;
    private String broadbandaccountidfaceflag;
    private String broadbandcodefaceflag;
    private String eparchycode;
    private String provincecode;
    private String broadbandcode;
    private String newspeed;
    private String broadbandaccountid;
    private String contactphone;
}
