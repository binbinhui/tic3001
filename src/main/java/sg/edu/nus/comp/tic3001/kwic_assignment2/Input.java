package sg.edu.nus.comp.tic3001.kwic_assignment2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

class Input {
    private static Scanner in = new Scanner(System.in);

    static void getInput() {
        boolean isExit = false;
        String line = in.nextLine();
        String command = getCommandWord(line);
        switch (command) {
            case "1":
                Main.runTest(0);
                break;
            case "2":
                for (int index = 1; index <= 5; ++index) Main.runTest(index);
                break;
            case "3":
                Extensions.wordsToIgnoreIncluded = !Extensions.wordsToIgnoreIncluded;
                UI.optionToggled(Extensions.wordsToIgnoreIncluded);
                break;
            case "4":
                Extensions.requiredWordsIncluded = !Extensions.requiredWordsIncluded;
                UI.optionToggled(Extensions.requiredWordsIncluded);
                break;
            case "5":
                isExit = true;
                UI.exit();
                break;
            default:
                UI.invalidCommand();
                break;
        }
        if (!isExit) UI.enterCommand();
    }

    static String getCommandWord(String input) {
        return input.trim().split(" ")[0];
    }

    void readFile(Lines lines, File file) throws IOException {
        for (String line : Files.readAllLines(Paths.get(String.valueOf(file)))) lines.insert(line);
    }
}
