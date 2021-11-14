package junit;

public class RandomNumber {

  double randnumber;

  public double calculateRandom(int value){

    java.util.Random rand = new java.util.Random(System.currentTimeMillis());
    randnumber = Math.floor(value * rand.nextDouble());
    return randnumber;

  }

}
