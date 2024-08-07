import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    //ReplaceText Method
    public String replaceText(){
        String replacedText = hamletData;

        //Replace "Hamlet" with "Leon"
        Pattern patternHamlet = Pattern.compile("\\bHamlet\\b");
        Matcher matcherHamlet = patternHamlet.matcher(replacedText);
        replacedText = matcherHamlet.replaceAll("Leon");

        //Replace "Horatio" with "Tariq"
        Pattern patternHoratio = Pattern.compile("\\bHoratio\\b");
        Matcher matcherHoratio = patternHoratio.matcher(replacedText);
        replacedText = matcherHoratio.replaceAll("Tariq");

        return replacedText;
    }

    //Method to save the modified text to a new file
    public void saveToFile(String outputPath) {
        try {
            Files.write(Paths.get(outputPath), replaceText().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
