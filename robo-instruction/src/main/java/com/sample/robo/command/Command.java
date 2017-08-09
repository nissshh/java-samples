/**
 * 
 */
package com.sample.robo.command;

/**
 * A command comprised of instrction and direction
 * 
 * @author nsonar
 *
 */

public class Command {

    Subject direction;

    Action instruction;

    public Command(Action instruction, Subject direction) {
        super();
        this.direction = direction;
        this.instruction = instruction;
    }

    public Subject getDirection() {
        return direction;
    }

    public void setDirection(Subject direction) {
        this.direction = direction;
    }

    public Action getInstruction() {
        return instruction;
    }

    public void setInstruction(Action instruction) {
        this.instruction = instruction;
    }

}
