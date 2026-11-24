import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GradeCalculatorTest {
    private GradeCalculator calc;

    @Before
    public void setUp() {
        calc = new GradeCalculator();
    }

    @Test
    public void lowerBoundOfEachGrade() {
        assertEquals("A",  calc.gradeOf(80)); 
        assertEquals("B+", calc.gradeOf(75)); 
        assertEquals("B",  calc.gradeOf(70)); 
        assertEquals("C+", calc.gradeOf(65)); 
        assertEquals("C",  calc.gradeOf(60));
        assertEquals("D+", calc.gradeOf(55)); 
        assertEquals("D",  calc.gradeOf(50)); 
        assertEquals("F",  calc.gradeOf(0));  
    }

    @Test
    public void normalAndEdgeCases() {
        assertEquals("A",  calc.gradeOf(85));
        assertEquals("A",  calc.gradeOf(100));
        assertEquals("B+", calc.gradeOf(79));
        assertEquals("F",  calc.gradeOf(49));  
    }

    @Test(expected = IllegalArgumentException.class)
    public void scoreAboveHundredThrows() {
        calc.gradeOf(101);
    }

    @Test
    public void scoreBelowZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gradeOf(-1));
    }
}