package com.example.Test;

import com.example.config.ExecutorConfig;
import com.example.domain.PersonPo;
import com.example.mapper.TestMapper;
import com.example.service.AsyncService;
import com.example.utils.JsonUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 郝少杰
 * @date 2021/2/19 10:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BootApplicationTests {

    int num = 0;
    @Value("${executor.corePoolSize}")
    int corePoolSize;

    private final CountDownLatch countDownLatch = new CountDownLatch(10);

    @Autowired
    private AsyncService asyncService;

    @Test
    public void mainWait() {
        try {
            List<Integer> list = Lists.newArrayList();
            for (int i=1;i<4001;i++){
                list.add(i);
            }
            int i1 = list.size() / 10;
            for (int i = 0; i < 10; i++) {
                asyncService.mainWait(countDownLatch,num,i1,list);
                num = num+i1;
            }
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
