/**
 * @author BJTU16301130
 */
public class PrintMe implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
