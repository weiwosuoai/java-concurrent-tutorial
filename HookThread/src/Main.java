import java.util.concurrent.TimeUnit;

/**
 * @author 犬小哈（微信号: 小哈学Java）
 * @date 2019/4/10
 * @time 下午9:56
 * @discription
 **/
public class Main {

    public static void main(String[] args) {
        // 为应用程序注入 Hook (钩子)线程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("The hook thread 1 is running.");
                // 休眠 2s
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("The hook thread 1 will exit.");
        }));

        // 再注册一个 Hook (钩子)线程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                System.out.println("The hook thread 2 is running.");
                // 休眠 2s
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("The hook thread 2 will exit.");
        }));

        System.out.println("The main thread will exit.");
    }

}
