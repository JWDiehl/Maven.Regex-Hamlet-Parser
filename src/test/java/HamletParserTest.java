import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //Get the processedText with replacements
        String processedText = hamletParser.replaceText();

        //Check that "Hamlet" is replaced with "Leon"
        assertFalse(processedText.contains("Hamlet"));
        assertTrue(processedText.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        //Get the processedText with replacements
        String processedText = hamletParser.replaceText();

        assertFalse(processedText.contains("Horatio"));
        assertTrue(processedText.contains("Tariq"));
    }

    @Test
    public void testFindHoratio() {
        //Get the processedText with replacements
        String originalText = hamletParser.getHamletData();

        //Check that "Horatio" is present in the OG text
        assertTrue(originalText.contains("Horatio"));
    }

    @Test
    public void testFindHamlet() {
        //Get the processedText with replacements
        String originalText = hamletParser.getHamletData();

        //Check that "Hamlet" is present in the OG text
        assertTrue(originalText.contains("Hamlet"));
    }
}