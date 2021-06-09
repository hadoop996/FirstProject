package com.example.domain.po.abilityPlatform;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author DongChengLong
 * @desc
 * @date 2021/03/02 20:26
 */
@NoArgsConstructor
@Data
public class UNI_BSS_HEAD {

    /**
     * RESP_DESC : 成功
     * TRANS_ID : 20210301165955842885732
     * TIMESTAMP : 2021-03-01 16:59:55 842
     * RESP_CODE : 00000
     * APP_ID : k4KYgtD3My
     */

    private String RESP_DESC;

    private String TRANS_ID;

    private String TIMESTAMP;

    private String RESP_CODE;

    private String APP_ID;
}
