/**
 * 
 */
package com.sample.robo.convertor;

import java.util.StringTokenizer;

import com.sample.robo.command.Command;
import com.sample.robo.command.Subject;
import com.sample.robo.command.Action;
import com.sample.robo.util.DirectionHelper;
import com.sample.robo.util.InstructionHelper;

/**
 * 
 * PArses a command line and converts in to Ronot comonds
 * 
 * @author nsonar
 *
 */
public class CommandConvertor {

    CommandValidator validator;

    public CommandConvertor() {
        validator = new CommandValidator();
    }

    public Command convert(String line) {
        Subject direction = Subject.NONE;
        Action instruction = Action.NONE;
        Command command = new Command(instruction, direction);
        if (validator.validate(line)) {
            command = getCommand(line);
        }
        return command;
    }

    private Command getCommand(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line);
        String dir = tokenizer.nextToken();
        Subject direction = DirectionHelper.getDirection(dir);
        String cmd = tokenizer.nextToken();
        Action instruction = InstructionHelper.getInstruction(cmd);
        Command command = new Command(instruction, direction);
        return command;
    }

}
