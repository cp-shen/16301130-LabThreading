/**
 * @author BJTU16301130
 */
public class TestThreeThreads{
    public static void main(String[] args) {
        PrintMe printMe = new PrintMe();

        Thread t1 = new Thread(printMe),
                t2 = new Thread(printMe),
                t3 = new Thread(printMe);

        t1.setName("thread1");
        t2.setName("thread2");
        t3.setName("thread3");
        t1.start();
        t2.start();
        t3.start();
    }
}
