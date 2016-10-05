package challange;

import org.junit.Test;
import static junit.framework.Assert.*;

public class LineTest {

    @Test
    public void testLineSlope(){
        //first point
        double x0 = 1.0d; double y0 = 1.0d;

        //second point
        double x1 = 1.5d; double y1 = 1.5d;

        Line line = new Line(x0, y0, x1, y1);
        assertEquals(1.0d, line.getSlope());

        //expect a higher result as line should be steeper since y0 has dropped.
        y0 = -1.5d;
        line = new Line(x0, y0, x1, y1);
        assertEquals(6.0d, line.getSlope());
    }


    @Test(expected = ArithmeticException.class)
    public void shouldThrowErrorWhenX1IsEqualToX0(){
        //first point
        double x0 = 1.0d; double y0 = 1.0d;

        //second point
        double x1 = 1.0d; double y1 = 1.5d;
        Line line = new Line(x0, y0, x1, y1);
        line.getSlope();
    }

    @Test
    public void testDistanceOfLine(){
        double expected = 0.7071067811865476d;

        //first point
        double x0 = 1.0d; double y0 = 1.0d;

        //second point
        double x1 = 1.5d; double y1 = 1.5d;

        Line line = new Line(x0, y0, x1, y1);
        assertEquals(expected, line.getDistance());
    }

    @Test
    public void testIsParallel(){
        Line line1 = new Line(1.0d, 1.0d, 1.5d, 1.5);
        Line line2 = new Line(2.0d, 2.0d, 2.5d, 2.5d);
        assertTrue(line1.parallelTo(line2));

        Line line3 = new Line(2.0d, 2.0d, 1.5d, 2.5d);
        assertFalse(line1.parallelTo(line3));

        Line line4 = new Line(2.0d, 2.0d, 1.5d, 2.5000001d);
        assertTrue(line3.parallelTo(line4));
    }
}
