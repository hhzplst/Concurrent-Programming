import java.lang.Math;

public class ComputeThread implements Runnable {
  private static double[] baseArr, expArr;
  private int lo, hi = 99999999;
  private int splitSize;

  public ComputeThread(double[] arr1, double[] arr2, int splitSize) {
    baseArr = arr1;
    expArr = arr2;
    this.splitSize = splitSize;
  }

  public void run() {
    while(lo + splitSize < hi) {
      int current = getLow();
      setLow(lo + splitSize + 1);
      double result = Math.pow(baseArr[current], expArr[current]);
    }
  }

  synchronized private int getLow() {
    return lo;
  }

  synchronized private void setLow(int newLo) {
    lo = newLo;
  }
}