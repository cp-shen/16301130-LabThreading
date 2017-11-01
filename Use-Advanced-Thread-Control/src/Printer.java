
public class Printer implements Runnable{
    private Queue printQueue;
    private boolean stateIsRunning;
    private final static Printer PRINTER = new Printer();
    private final static int CAPACITY = 10;

    private Printer(){
        stateIsRunning = true;
        System.out.println("Print manager is starting up");
        printQueue = new CircularQueue(CAPACITY);
    }

    public static Printer getPrinter(){
        return PRINTER;
    }

    public synchronized void addJob (PrintJob job){
        try{
            printQueue.addBack(job);
            System.out.println("added a print job "
                    +"[job name] "+job.getName());
            notify();
        }catch(FullQueueException ex){
            System.out.println("The producer is adding a job to the print queue");
            try{
                wait();
            }catch(InterruptedException ex1){
                ex1.printStackTrace();
            }
        }
    }

    private synchronized PrintJob getJob(){
        if(printQueue.isEmpty()){
            try{
                wait();
            }catch(InterruptedException ex){
            }
        }
        PrintJob job =(PrintJob) printQueue.removeFront();
        notify();
        return job;
    }

    public synchronized void halt(){
            stateIsRunning = false;
    }

    @Override
    public void run() {
        PrintJob printJob;
        while(stateIsRunning == true || printQueue.isEmpty() == false){
            try{
                printJob = getJob();
                System.out.println("A print job is starting "
                        +"[job name] "+printJob.getName());
                Thread.sleep(200 * printJob.getPages());
                System.out.println("[job name] "+printJob.getName()+" completed.");
            }catch(InterruptedException ex){
            }catch(EmptyQueueException ex){
                System.out.println("Waiting for a job.");
                try{
                    Thread.sleep(500);
                }catch(InterruptedException ex1){
                }
            }
        }
        System.out.println("The printer is halted.");
    }
}
