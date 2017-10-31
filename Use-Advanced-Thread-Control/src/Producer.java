import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable{
    private int sizeOfJobs;
    private int numberOfJobs;
    private int delayBetweenJobs;
    private String producerName;

    public Producer(int sizeOfJobs, int numberOfJobs,
                    int delayBetweenJobs, String producerName){
        this.sizeOfJobs = sizeOfJobs;
        this.numberOfJobs = numberOfJobs;
        this.delayBetweenJobs = delayBetweenJobs;
        this.producerName = producerName;
    }
    @Override
    public void run() {
        List<PrintJob> printJobs = new ArrayList<>();
        for(int i=0; i<numberOfJobs; i++){
            printJobs.add(new PrintJob(producerName+i, sizeOfJobs));
        }
    }
}
