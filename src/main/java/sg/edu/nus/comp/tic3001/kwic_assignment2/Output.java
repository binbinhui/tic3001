package sg.edu.nus.comp.tic3001.kwic_assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Output {
    void writeFile(Lines lines, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (String line : lines.all()) {
            fileWriter.append(line).append('\n');
        }
        fileWriter.flush();
    }
}
