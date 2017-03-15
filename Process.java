import java.lang.Math;

public class Process {
  public static void main(String[] args) {
    double[] baseArr = new double[10000000];
    double[] expArr = new double[10000000];

    for (int i = 0; i < 10000000; i++) {
      baseArr[i] = Math.random() * 500;
      expArr[i] = Math.random() * 50;
    }

    Thread t1 = new Thread(new ComputeThread(baseArr, expArr));
    Thread t2 = new Thread(new ComputeThread(baseArr, expArr));
    Thread t3 = new Thread(new ComputeThread(baseArr, expArr));
    Thread t4 = new Thread(new ComputeThread(baseArr, expArr));
    Thread t5 = new Thread(new ComputeThread(baseArr, expArr));
    Thread t6 = new Thread(new ComputeThread(baseArr, expArr));
    Thread t7 = new Thread(new ComputeThread(baseArr, expArr));
    Thread t8 = new Thread(new ComputeThread(baseArr, expArr)); 

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
    System.out.println("Elapsed time was " + (stopTime - startTime) + " milliseconds for one thread and sub-size of 1000.");
  }
}


/****************************************OUTPUT****************************************



***************************************END OUTPUT**************************************/
