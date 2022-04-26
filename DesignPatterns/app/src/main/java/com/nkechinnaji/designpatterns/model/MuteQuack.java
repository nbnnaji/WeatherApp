package com.nkechinnaji.designpatterns;

public class MuteQuack implements QuackBehavior {

    public void quack() {
        System.out.println("I can't quack. So sad!");
    }
}
