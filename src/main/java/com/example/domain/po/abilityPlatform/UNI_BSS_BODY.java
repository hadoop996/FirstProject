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
public class UNI_BSS_BODY {
    /**
     * NUMBER_ADD_ROLE_RSP : {"ROOT":{"RSP_CODE":"1","RSP_DESC":"未查到该条数据！"}}
     */

    private NUMBER_ADD_ROLE_RSP NUMBER_ADD_ROLE_RSP;

    private QRYROUTEALL_RSP QRYROUTEALL_RSP;
}
