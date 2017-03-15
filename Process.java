import java.lang.Math;

public class Process {
  public static void main(String[] args) {
    double[] baseArr = new double[10000000];
    double[] expArr = new double[10000000];

    for (int i = 0; i < 10000000; i++) {
      baseArr[i] = Math.random() * 500;
      expArr[i] = Math.random() * 50;
    }

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
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
    t8.start();
    try {
     t1.join();
     t2.join();
     t3.join();
     t4.join();
     t5.join();
     t6.join();
     t7.join();
     t8.join();
    } catch(InterruptedException e) {
      e.printStackTrace();
    } 
    long stopTime = System.currentTimeMillis();
    System.out.println("Elapsed time was " + (stopTime - startTime) + " milliseconds for eight threads and sub-size of 100000.");
  }
}


/****************************************OUTPUT****************************************

Elapsed time was 1075 milliseconds for one thread and sub-size of 1000.
Elapsed time was 547 milliseconds for two threads and sub-size of 1000.
Elapsed time was 310 milliseconds for four threads and sub-size of 1000.
Elapsed time was 339 milliseconds for eight threads and sub-size of 1000.

Elapsed time was 977 milliseconds for one thread and sub-size of 10000.
Elapsed time was 557 milliseconds for two threads and sub-size of 10000.
Elapsed time was 311 milliseconds for four threads and sub-size of 10000.
Elapsed time was 318 milliseconds for eight threads and sub-size of 10000.

Elapsed time was 994 milliseconds for one thread and sub-size of 100000.
Elapsed time was 566 milliseconds for two threads and sub-size of 100000.
Elapsed time was 320 milliseconds for four threads and sub-size of 100000.
Elapsed time was 345 milliseconds for eight threads and sub-size of 100000.

***************************************END OUTPUT**************************************/
