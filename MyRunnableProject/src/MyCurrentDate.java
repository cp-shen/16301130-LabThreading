import java.time.LocalDateTime;
/**
 * @author BJTU16301130
 */
public class MyCurrentDate implements Runnable{
    public void run(){
        for(int i = 0; i < 10; i++){
            System.out.println(LocalDateTime.now());
            try{
                Thread.sleep(100);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
