public class Process {
  public static void main(String[] args) {

    Thread t1 = new Thread(new ComputeThread());
    Thread t2 = new Thread(new ComputeThread());
    Thread t3 = new Thread(new ComputeThread());
    Thread t4 = new Thread(new ComputeThread());
    Thread t5 = new Thread(new ComputeThread());
    Thread t6 = new Thread(new ComputeThread());
    Thread t7 = new Thread(new ComputeThread());
    Thread t8 = new Thread(new ComputeThread()); 

    long startTime = System.currentTimeMillis();
    t1.start();
    //t2.start();
    //t3.start();
    //t4.start();
    //t5.start();
    //t6.start();
    //t7.start();
    //t8.start();
    try {
     t1.join();
     //t2.join();
     //t3.join();
     //t4.join();
     //t5.join();
     //t6.join();
     //t7.join();
     //t8.join();
    } catch(InterruptedException e) {
      e.printStackTrace();
    } 
    long stopTime = System.currentTimeMillis();
    System.out.println("Elapsed time was " + (stopTime - startTime) + " milliseconds for two threads and sub-size of 1000.");
  }
}


/****************************************OUTPUT****************************************

Elapsed time was 1004 milliseconds for one thread and sub-size of 1000.
Elapsed time was 543 milliseconds for two threads and sub-size of 1000.
Elapsed time was 311 milliseconds for four threads and sub-size of 1000.
Elapsed time was 328 milliseconds for eight threads and sub-size of 1000.

Elapsed time was 1010 milliseconds for one thread and sub-size of 10000.
Elapsed time was 541 milliseconds for two threads and sub-size of 10000.
Elapsed time was 301 milliseconds for four threads and sub-size of 10000.
Elapsed time was 304 milliseconds for eight threads and sub-size of 10000.

Elapsed time was 988 milliseconds for one thread and sub-size of 100000.
Elapsed time was 555 milliseconds for two threads and sub-size of 100000.
Elapsed time was 300 milliseconds for four threads and sub-size of 100000.
Elapsed time was 319 milliseconds for eight threads and sub-size of 100000.

***************************************END OUTPUT**************************************/
