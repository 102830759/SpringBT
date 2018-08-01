package my.test.aysc.testaysc;

import my.test.aysc.testaysc.config.ContextUtil;
import my.test.aysc.testaysc.task.AsyncTaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestayscApplicationTests {

    @Test
    public void contextLoads() throws InterruptedException, ExecutionException {
        AsyncTaskService asyncTaskService = ContextUtil.getBean(AsyncTaskService.class);

        List<Future<String>> lstFuture = new ArrayList<Future<String>>();// 存放所有的线程，用于获取结果

        // 创建100个线程
        for (int i = 0; i <= 100; i++) {
            while (true) {
                try {
                    // 线程池超过最大线程数时，会抛出TaskRejectedException，则等待1s，直到不抛出异常为止
                    Future<String> future = asyncTaskService.asyncInvokeReturnFuture(i);
                    lstFuture.add(future);

                    break;
                } catch (TaskRejectedException e) {
                    System.out.println("线程池满，等待1S。");
                    Thread.sleep(1000);
                }
            }
        }

        // 获取值。get是阻塞式，等待当前线程完成才返回值
        for (int i = 0; i < lstFuture.size(); i++) {
            try {
                System.out.println(lstFuture.get(i).get());
            } catch (Exception e) {
                System.out.println("任务：" + i + "执行失败！！！");
            }

        }

    }
}
