package task9;

import task9.Ball;
import task9.Basket;

public class Main {

    public static void main(String[] args) {
        var basket = new Basket();

        var ball1 = new Ball(5,"blue");
        var ball2 = new Ball(3,"red");
        var ball3 = new Ball(5,"blue");

        basket.addBall(ball1);
        basket.addBall(ball2);
        basket.addBall(ball3);

        System.out.printf("weight:%.1f \n",basket.getBasketWeight());
        System.out.printf("count:%d \n",basket.getBallNumber("blue"));
    }
}
