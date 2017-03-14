public class ConcurrentProgramming {
  private int lo, hi;

  synchronized public int getLow() {
    return lo;
  }

  synchronized public void setLow(int newLo) {
    lo = newLo;
  }

  synchronized public int getHi() {
    return hi;
  }

  synchronized public void setHi(int newHi) {
    hi = newHi;
  }
}