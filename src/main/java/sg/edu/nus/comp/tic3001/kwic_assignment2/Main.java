package sg.edu.nus.comp.tic3001.kwic_assignment2;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import static sg.edu.nus.comp.tic3001.kwic_assignment2.Main.FileName.*;
import static sg.edu.nus.comp.tic3001.kwic_assignment2.Extensions.*;

public class Main {
    public static void main(String[] args) {
        UI.welcomeMessage();
        UI.enterCommand();
        
        ListMultimap<String, String> modules = ArrayListMultimap.create();
		// Add pairs to ListMultimap. 
		modules.put("CS", "3219"); 
		modules.put("CS", "4218"); 
		modules.put("MA", "1101R"); 
		modules.put("MA", "1100"); 
		modules.put("IS", "1103");
		// Get list at this key. 
		List<String> csModules = modules.get("CS"); 
		for (String code : csModules) { 
			System.out.println("CS" + code); 
			}
    }

    public static class FileName {
        public static String folder(String fileName) {
            int index = Integer.parseInt(fileName.replaceAll("\\D+",""));
            return "TIC3001-Assignment2-testcases/Test" + index + "/" + fileName;
        }
        public static String input(int index) {
            return "Titles" + index + ".txt";
        }
        public static String output(int index) {
            return "OurOutput" + index + ".txt";
        }
        public static String ignored(int index) {
            return "Ignored" + index + ".txt";
        }
        public static String required(int index) {
            return "Required" + index + ".txt";
        }
    }

    public static void runTest(int index) {
        Lines lines = new Lines();
        Lines shiftedLines = new Lines();
        Input input = new Input();
        Output output = new Output();

        CircularShift circularShift = new CircularShift(shiftedLines);
        Alphabetizer alphabetizer = new Alphabetizer();

        lines.addObserver(circularShift);
        shiftedLines.addObserver(alphabetizer);

        haveError = false;
        updateAllWords(index);
        checkForMultipleWords(ignoredWords, folder(ignored(index)));
        checkForMultipleWords(requiredWords, folder(required(index)));
        checkForDuplicateWords(index);
        if (haveError) return;

        try {
            input.readFile(lines, new File(folder(input(index))));
            output.writeFile(shiftedLines, new File(folder(output(index))));
            UI.fileCreated(output(index));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
