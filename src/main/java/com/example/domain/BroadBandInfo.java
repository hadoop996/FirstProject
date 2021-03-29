package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 郝少杰
 * @date 2021/3/25 16:03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BroadBandInfo {
    private String engineerAccount;
    private String userBroadcast;
    private String note;
    private String engineerProvince;
}
