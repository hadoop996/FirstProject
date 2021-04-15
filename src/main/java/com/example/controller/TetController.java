package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.example.service.TetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author 郝少杰
 * @date 2021/2/10 11:55
 */
@Slf4j
@RestController
@RequestMapping("/engineer/")
public class TetController {

    @Autowired
    TetService tetService;

    /**
     * 测试
     *
     * @param
     * @return
     */
    @PostMapping(value = "test")
    public void qryAdminSearProvince() throws Exception {
        log.error("123");
        log.info("123");
        boolean safeMode = ParserConfig.getGlobalInstance().isSafeMode();
        System.out.println(safeMode);
        tetService.getSql();
    }
}
