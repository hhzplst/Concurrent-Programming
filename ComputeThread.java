import java.lang.Math;

public class ComputeThread implements Runnable {
  private static double[] baseArr, expArr;
  private static int lo;
  private static final int HI = 9999999, SPLIT_SIZE = 1000;
  private static boolean done = false;

  public ComputeThread(double[] arr1, double[] arr2) {
    baseArr = arr1;
    expArr = arr2;
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
        for (int i = current; i < current + SPLIT_SIZE; i++)
          result = Math.pow(baseArr[i], expArr[i]);
        setLow(lo + SPLIT_SIZE);
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