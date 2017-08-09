/**
 * 
 */
package com.sample.robo.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import com.sample.robo.command.Command;
import com.sample.robo.convertor.CommandConvertor;

/**
 * @author nsonar
 *
 */
public class FileCommandParser implements CommandParser<FileReader> {

    @Override
    public List<Command> parse(FileReader stream) {
        BufferedReader bufferedReader = new BufferedReader(stream);
        return bufferedReader.lines().map(new CommandConvertor()::convert).collect(Collectors.toList());
    }

}
