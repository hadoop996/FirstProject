package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 郝少杰
 * @date 2021/3/19 11:16
 */
@Data
public class ResultBo implements Serializable {
    private List<BroadbandBO> BroadbandBO;
    private String rsp_code;
    private String rsp_desc;
}
