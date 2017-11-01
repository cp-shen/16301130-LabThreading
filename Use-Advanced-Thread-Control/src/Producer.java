
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
        for(int i=0; i<numberOfJobs; i++){
            try{
                Printer.getPrinter().addJob(new PrintJob(producerName +" job"+i,sizeOfJobs));
                Thread.sleep(delayBetweenJobs);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

}
