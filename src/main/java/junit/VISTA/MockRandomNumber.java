package junit.VISTA;

import junit.VISTA.RandomNumber;

public class MockRandomNumber extends RandomNumber {

  @Override
  public double calculateRandom(int value) {
    double ret = 25;
    return ret;

  }

}
