package org.example;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCentre {
    private static final int CALLS_FREQ = 1000;
    private static final int ANSWER_DURATION = 3000;
    private static final int TOTAL_CALLS = 40;
    private static final int CALLS_PER_SECOND = 10;
    private int currCall = 0;

    private final Queue<String> incomingCalls = new ConcurrentLinkedQueue<>();

    public void incomingCalls() {
        try {
            while (currCall < TOTAL_CALLS) {
                for (int i = 0; i < CALLS_PER_SECOND; i++) {
                    int countCalls = 1;
                    incomingCalls.add(countCalls + currCall + " входящий звонок");
                    currCall++;
                }
                Thread.sleep(CALLS_FREQ);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void acceptCalls() {
        try {
            while (!incomingCalls.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + " взял " + incomingCalls.poll());
                Thread.sleep(ANSWER_DURATION);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
