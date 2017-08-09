/**
 * 
 */
package com.sample.robo;

import com.sample.robo.command.Command;
import com.sample.robo.util.PositionFinder;

/**
 * @author nsonar
 *
 */
public class Robot {

    Position position; // (uses coordinates lat,lang,altitude)

    String name;

    public Robot(Position position, String name) {
        super();
        this.position = position;
        this.name = name;
    }

    public void follow(Command command) {
        position = PositionFinder.getNextPosition(position, command);
        String print = String.format("Robot (%s) is now (%s) to (%s)  at ", name, command.getInstruction(), command.getDirection(), position);
        System.out.println(print);
    }
}
