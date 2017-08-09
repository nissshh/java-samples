/**
 * 
 */
package com.sample.robo.parser;

import java.util.List;

import com.sample.robo.command.Command;

/**
 * 
 * Parses the instructions
 * 
 * @author nsonar
 *
 */
public interface CommandParser<T> {

    List<Command> parse(T stream);
}
