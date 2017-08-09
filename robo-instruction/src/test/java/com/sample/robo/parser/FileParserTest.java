package com.sample.robo.parser;
/**
 * 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sample.robo.command.Action;
import com.sample.robo.command.Command;
import com.sample.robo.command.Subject;

/**
 * @author nsonar
 *
 */
public class FileParserTest {

    FileCommandParser commandParser;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setup() throws Exception {
        // File file = folder.newFile("commands.txt");
        // file.createNewFile();
        // FileWriter fileWriter = new FileWriter(file);
        // testCommands().stream().forEach(cmd -> fileWriter.write(cmd));
        commandParser = new FileCommandParser();

    }

    private List<Command> testCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new Command(Action.MOVE, Subject.UP));// MOVE UP
        commands.add(new Command(Action.TURN, Subject.LEFT));// TURN LEFT
        commands.add(new Command(Action.PUSH, Subject.BOX));// PUSH BOX
        commands.add(new Command(Action.TURN, Subject.RIGHT));// TURN RIGHT
        commands.add(new Command(Action.MOVE, Subject.DOWN));// MOVE DOWN

        return commands;
    }

    @Test
    public void test() throws FileNotFoundException {
        // FileReader fileReader = new FileReader(folder.getRoot().getAbsolutePath() + File.pathSeparator + "commands.txt");
        Optional<URL> file = Optional.ofNullable(FileParserTest.class.getClassLoader().getResource("commands.txt"));
        if (file.isPresent()) {
            FileReader fileReader = new FileReader(FileParserTest.class.getClassLoader().getResource("commands.txt").getPath());
            List<Command> result = commandParser.parse(fileReader);
            Assert.assertEquals(testCommands(), result);
        } else {
            Assert.fail("File not found");
        }
    }
}
