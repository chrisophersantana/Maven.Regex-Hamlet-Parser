import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Leon");
        Assert.assertTrue(hamletText.contains("Leon"));
        Assert.assertFalse(hamletText.contains("Hamlet"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(hamletText);
        hamletText = matcher.replaceAll("Tariq");
        Assert.assertTrue(hamletText.contains("Tariq"));
        Assert.assertFalse(hamletText.contains("Horatio"));
    }

    @Test
    public void testFindHoratio() {
        String replaced = hamletParser.replacer("Hamlet", "Leon", hamletText);
        Assert.assertTrue(replaced.contains("Leon"));
        Assert.assertFalse(replaced.contains("Hamlet"));
    }

    @Test
    public void testFindHamlet() {
        String replaced = hamletParser.replacer("Horatio", "Tariq", hamletText);
        Assert.assertTrue(replaced.contains("Tariq"));
        Assert.assertFalse(replaced.contains("Horatio"));
    }
}