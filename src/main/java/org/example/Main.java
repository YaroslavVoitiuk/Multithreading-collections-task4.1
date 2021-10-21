package org.example;

public class Main {
    public static void main( String[] args )  {
        CallCentre callCentre = new CallCentre();

        new Thread(callCentre::incomingCalls,"АТС").start();
        new Thread(callCentre::acceptCalls, "Оператор 1").start();
        new Thread(callCentre::acceptCalls, "Оператор 2").start();
        new Thread(callCentre::acceptCalls, "Оператор 3").start();
        new Thread(callCentre::acceptCalls, "Оператор 4").start();


    }
}
