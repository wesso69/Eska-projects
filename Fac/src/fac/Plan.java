package fac;

abstract class Plan {

    protected double rate;

    abstract void getRate();

    public void calcBil(int units) {
        System.out.println(units * rate);
    }
}
