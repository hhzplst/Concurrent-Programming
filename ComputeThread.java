import java.lang.Math;

public class ComputeThread implements Runnable {
  private static double[] baseArr, expArr;
  private static int index;
  private static final int HI = 9999999, SPLIT_SIZE = 1000;
  private static boolean done = false, last = false;

  static {
    baseArr = new double[10000000];
    expArr = new double[10000000];

    for (int i = 0; i < 10000000; i++) {
      baseArr[i] = Math.random() * 500;
      expArr[i] = Math.random() * 50;
    }
  }

  public void run() {
    double result;
    while(!done) {
      int current = claimWork();
      if (last) {
        for (int i = current; i < HI; i++)
          result = Math.pow(baseArr[i], expArr[i]);
      }
      else {
        for (int i = current; i < current + SPLIT_SIZE; i++)
          result = Math.pow(baseArr[i], expArr[i]);
      }
    }
  }

  synchronized private int claimWork() {
    int result;
    if (index + SPLIT_SIZE > HI) {
      done = last = true;
      return index;
    } else {
      result = index;
      //no two threads are working on the same segment
      setIndex(index + SPLIT_SIZE);
      return result;
    }
  }

  synchronized private void setIndex(int newIndex) {
    index = newIndex;
  }
}