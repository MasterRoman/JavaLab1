package task9;
import java.util.ArrayList;

import task9.Ball;

public class Basket {
    private ArrayList<Ball> storage;

    Basket() {
        this.storage = new ArrayList<Ball>();
    }

    public void addBall(Ball ball) {
        storage.add(ball);
    }

    public double getBasketWeight() {
        int weight = 0;
        for (Ball ball:storage) {
            weight += ball.weight;
        }
        return  weight;
    }

    public int getBallNumber(String color) {
        int number = 0;
        for (Ball ball:storage) {
            if (ball.color == color) {
                number += 1;
            }
        }
        return  number;
    }
}
