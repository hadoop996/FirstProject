package com.example.work;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


/**
 * @author 郝少杰
 * @date 2020/12/28 18:23
 */
@Slf4j
public class SmartEngineer {
    public static void main(String[] args) {
        URI serverUri = UriComponentsBuilder.fromUriString("http://123/123").
                queryParam("engineer","13932652667").
                build().encode().toUri();
        System.out.println(serverUri);
    }

}
