public class ConcurrentProgramming {
  private int lo, hi = 99999999;
  private int splitSize;

  public ConcurrentProgramming(int splitSize) {
    this.splitSize = splitSize;
  }

  synchronized public int getLow() {
    return lo;
  }

  private void setLow(int newLo) {
    lo = newLo;
  }

  synchronized public int getHi() {
    return hi;
  }

  private void setHi(int newHi) {
    hi = newHi;
  } 
}