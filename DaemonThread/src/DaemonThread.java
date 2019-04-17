import java.util.concurrent.TimeUnit;

/**
 * @author 犬小哈（微信号: 小哈学Java）
 * @date 2019/4/10
 * @time 下午9:56
 * @discription
 **/
public class DaemonThread {


    public static void main(String[] args) throws InterruptedException {

        // 设置一个钩子线程，在 JVM 退出时输出日志
        Runtime.getRuntime()
                .addShutdownHook(new Thread(() -> System.out.println("The JVM exit success !!!")));

        // 在主线程中 new 一个非守护线程
        Thread thread = new Thread(() -> {
            // 模拟非守护线程不退出的情况
            while (true) {
                try {
                    // 睡眠一秒
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("I am running ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 将该线程设置为守护线程
        thread.setDaemon(true);
        // 启动线程
        thread.start();

        TimeUnit.SECONDS.sleep(2);

        // 主线程即将退出
        System.out.println("The main thread ready to exit..");
    }
}
