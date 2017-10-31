/**
 * @author BJTU16301130
 */
public class MyMain{
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyCurrentDate());
        Thread t2 = new Thread(new MyCurrentDate());
        Thread t3 = new Thread(new MyCurrentDate());

        t1.start();
        t2.start();
        t3.start();
    }
}
