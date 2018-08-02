package my.test.aysc.testaysc.task;

import io.webfolder.cdp.Launcher;
import io.webfolder.cdp.session.Session;
import io.webfolder.cdp.session.SessionFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author huyue@hdsxtech.com
 * @date 2018/8/1 17:08
 */
@Service
// 线程执行任务类
public class AsyncTaskService {

    Random random = new Random();// 默认构造方法

    @Async
    // 表明是异步方法
    // 无返回值
    public void executeAsyncTask(Integer i) {
        System.out.println("执行异步任务：" + i);
    }

    /**
     * 异常调用返回Future
     *
     * @param
     * @return
     * @throws InterruptedException
     */
    @Async
    public Future<String> asyncInvokeReturnFuture(String url) throws InterruptedException {
        System.out.println("input is :" + url);
//        Thread.sleep(1000 * random.nextInt(i));
        Future<String> future;
        ArrayList<String> command = new ArrayList<String>();
        //不显示google 浏览器
        command.add("--headless");

        Launcher launcher = new Launcher();
        try (SessionFactory factory = launcher.launch(command);
             Session session = factory.create()) {
            try {
                session.navigate(url);
                session.waitDocumentReady(5000);

                // activate the tab/session before capturing the screenshot
                session.activate();
                byte[] data = session.captureScreenshot();
                byte2image(data, "D:\\picture\\" + System.currentTimeMillis() + ".png");
                System.out.println("线程：" + Thread.currentThread().getName() + "，执行了任务编号：" + url + ",执行成功");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("线程：" + Thread.currentThread().getName() + "，执行了任务编号：" + url + ",执行失败");
            } finally {
                future = new AsyncResult<String>("线程：" + Thread.currentThread().getName() + "，执行了任务编号：" + url);
            }

        }
        return future;

    }

    public int doSoming(int i) {
        return i / i;
    }

    public static void byte2image(byte[] data, String path) {
        if (data.length < 3 || path.equals("")) {
            return;
        }
        try {
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }
}
