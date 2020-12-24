package com.example.ALLTest;

import com.example.config.RegistryCenterProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;


@Slf4j
@Configuration
public class CacheWatch {

    @Resource
    private RegistryCenterProperties registryCenterProperties;
    @Resource
    private CuratorFramework zkClient;

    @Bean
    public PathChildrenCache dataWatcherListenable() throws Exception {
        String listenPath = registryCenterProperties.getListenerNode();
        System.out.println("listenPath:" + listenPath);
        final PathChildrenCache childrenCache = new PathChildrenCache(zkClient, listenPath, true);
        log.info("监听节点:" + listenPath);
        childrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        childrenCache.getListenable().addListener(
                (client, event) -> {
                    switch (event.getType()) {
                        case CHILD_ADDED:
                            log.info("CHILD_ADDED: {}, DATA: {}", event.getData().getPath(), new String(event.getData().getData()));
                            break;
                        case CHILD_REMOVED:
                            log.info("CHILD_REMOVED: {}, DATA: {}", event.getData().getPath(), new String(event.getData().getData()));
                            break;
                        case CHILD_UPDATED:
                            log.info("CHILD_UPDATED: {}, DATA: {}", event.getData().getPath(), new String(event.getData().getData()));
                            break;
                        case CONNECTION_SUSPENDED:
                            break;
                        case CONNECTION_RECONNECTED:
                            break;
                        case CONNECTION_LOST:
                            break;
                        case INITIALIZED:
                            break;
                        default:
                            break;
                    }
                }
        );
        return childrenCache;
    }
}
