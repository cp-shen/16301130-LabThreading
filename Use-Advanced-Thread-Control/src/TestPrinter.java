public class TestPrinter{
    public static void main(String[] args){
        Producer producer1 = new Producer(5,5,1*1000,"producer1");
        Producer producer2 = new Producer(10,5,2*1000,"producer2");
        Producer producer3 = new Producer(15,5,3*1000,"producer3");

        Thread printerThread = new Thread(Printer.getPrinter());
        printerThread.setPriority(Thread.MAX_PRIORITY);
        printerThread.start();

        Thread producerThread1 = new Thread(producer1);
        Thread producerThread2 = new Thread(producer2);
        Thread producerThread3 = new Thread(producer3);

        producerThread1.start();
        producerThread2.start();
        producerThread3.start();

        try{
            producerThread1.join();
            producerThread2.join();
            producerThread3.join();
        }catch(InterruptedException ex){
            ex.printStackTrace();
        }

        Printer.getPrinter().halt();
    }
}
