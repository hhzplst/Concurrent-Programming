import java.lang.Math;

public class ComputeThread implements Runnable {
  private static double[] baseArr, expArr;
  private static int lo;
  private static final int HI = 9999999, SPLIT_SIZE = 100000;
  private static boolean done = false;

  static {
    baseArr = new double[10000000];
    expArr = new double[10000000];

    for (int i = 0; i < 10000000; i++) {
      baseArr[i] = Math.random() * 500;
      expArr[i] = Math.random() * 50;
    }
  }

  public void run() {
    while(!done) {
      int current = getLow();
      double result;
      if (current + SPLIT_SIZE > HI) {
        for (int i = current; i < HI; i++)
          result = Math.pow(baseArr[i], expArr[i]);
        done = true;
      }
      else {
        setLow(lo + SPLIT_SIZE);
        for (int i = current; i < current + SPLIT_SIZE; i++)
          result = Math.pow(baseArr[i], expArr[i]);
      }
    }
  }

  synchronized private int getLow() {
    return lo;
  }

  synchronized private void setLow(int newLo) {
    lo = newLo;
  }
}