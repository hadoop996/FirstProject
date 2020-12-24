package com.example.H5;

import lombok.Data;

/**
 * @author 郝少杰
 * @date 2020/9/21 18:20
 */
@Data
public class MemberInfoRsp {
    private String code;
    private String desc;
    private MemberInfoPo data;
}
