package com.example.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: renchenkai
 * @Date: 2020/11/25 16:52：
 * @Version: 1.0
 * @Description: TODO
 */
@Data
public class EopEntityBO implements Serializable {
    private static final long serialVersionUID = -8021581010939540116L;
    String respdesc;
    String busiorder;
    List<BoardInformationBO> boardinfo;
    String respcode;
}
