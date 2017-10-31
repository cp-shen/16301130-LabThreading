
public class Printer implements Runnable{
    private Queue printQueue;
    private boolean stateIsRunning;
    private final static Printer PRINTER = new Printer();

    private Printer(){
        stateIsRunning = false;
        printQueue = new CircularQueue(10);
    }

    public static Printer getPrinter(){
        return PRINTER;
    }

    public synchronized void addJob(PrintJob job){
        
    }

    private PrintJob getJob(){

    }

    @Override
    public void run() {

    }
}
