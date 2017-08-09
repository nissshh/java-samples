/**
 * 
 */
package com.sample.robo.util;

import com.sample.robo.Position;
import com.sample.robo.command.Command;
import com.sample.robo.command.Subject;
import com.sample.robo.command.Action;

/**
 * 
 * Calculates the next position
 * 
 * @author nsonar
 *
 */
public class PositionFinder {

    public static Position getNextPosition(Position currentPosition, Command command) {
        return getNextPosition(currentPosition, command.getDirection(), command.getInstruction());
    }

    public static Position getNextPosition(Position currentPosition, Subject direction, Action instruction) {

        if (direction == Subject.LEFT) {
            currentPosition.setLat(currentPosition.getLat() + instruction.getSpeed());
        }
        if (direction == Subject.RIGHT) {
            currentPosition.setLat(currentPosition.getLat() - instruction.getSpeed());
        }

        if (direction == Subject.UP) {
            currentPosition.setLat(currentPosition.getAlt() + instruction.getSpeed());
        }

        if (direction == Subject.DOWN) {
            currentPosition.setLat(currentPosition.getAlt() - instruction.getSpeed());
        }

        if (direction == Subject.FWD) {
            currentPosition.setLat(currentPosition.getLng() + instruction.getSpeed());
        }

        if (direction == Subject.REV) {
            currentPosition.setLat(currentPosition.getLng() - instruction.getSpeed());
        }
        return currentPosition;

    }
}
