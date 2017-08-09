/**
 * 
 */
package com.sample.robo.command;

/**
 * 
 * Contains mostly the actvities or verbs
 * 
 * @author nsonar
 *
 */
public enum Action {
    WALK(2),
    SPRINT(4),
    JOG(3),
    CRAWL(1),
    STOP(0),
    TURN(0),
    MOVE(0),
    NONE(0),
    PUSH(0);

    int speed;

    Action(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

}
