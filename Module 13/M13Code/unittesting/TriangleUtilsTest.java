package unittesting;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class TriangleUtilsTest {
	
	private int a, b, c;
	private boolean result;
	
	public TriangleUtilsTest(int a, int b, int c, boolean result) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.result = result;
	}

	@Parameters
	public static Collection<Object[]> setUpTestCases() {
		return Arrays.asList(new Object[][] {
			{3, 3, 3, false}, // test case 0
			{1, 2, 3, false}, // test case 1
			{1, 1, 2, true},
			{1, 2, 1, true},
			{2, 1, 1, true}
			});
	}


	@Test
	public void testIsIsoceles() {
		System.out.println("testing with " + a+b+c);
		assertEquals(result, TriangleUtils.isIsoceles(a, b, c));
	}
	
	
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeLength() {
        TriangleUtils.isIsoceles(-1, 1, 1);
    }
    
    // should test with: 1, -1, 1;  1, 1, -1;  -1, -1, 1;  etc.
    // maybe create a second parameterized test class!

}
