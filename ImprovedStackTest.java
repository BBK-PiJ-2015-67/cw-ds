import org.junit.*;
import static org.junit.Assert.*;

public class ImprovedStackTest {

    @Test
    public void improvedStackTest() {
        ImprovedStack stack = new ImprovedStackImpl(new ArrayList());

        assertEquals("stack should be empty", stack.isEmpty(), true);
        assertEquals("stack should have size 0", stack.size(), 0);

        ReturnObject top = stack.top();

        assertEquals("top should have an error", top.hasError(), true);
        assertEquals("top should return empty structure error", top.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("top should return null as value", top.getReturnValue(), null);

        ReturnObject pop = stack.pop();

        assertEquals("pop should have an error", pop.hasError(), true);
        assertEquals("pop should return empty structure error", pop.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertEquals("pop should return null as value", pop.getReturnValue(), null);

    }

    @Test
    public void improvedStackNullTest() {
        Stack stack = new ImprovedStackImpl(null);

        assertTrue("stack should be empty", stack.isEmpty());
        assertEquals("stack should have size 0", stack.size(), 0);

        stack.push("Sample item");

        assertTrue("stack should still be empty", stack.isEmpty());
        assertEquals("stack should still have size 0", stack.size(), 0);

        ReturnObject top = stack.top();

        assertTrue("top should have an error", top.hasError());
        assertEquals("top should return empty structure error", top.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("top should return null as value", top.getReturnValue());

        ReturnObject pop = stack.pop();

        assertTrue("pop should have an error", pop.hasError());
        assertEquals("pop should return empty structure error", pop.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("pop should return null as value", pop.getReturnValue());
    }

    @Test
    public void improvedStackStressTest() {
        ImprovedStack stack = new ImprovedStackImpl(new ArrayList());

        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            stack.push(i);
        }

        assertEquals("stack should have 1 million items", stack.size(), oneMillion);
        assertFalse("stack should not be empty", stack.isEmpty());

        ReturnObject top = stack.top();

        assertEquals("top should be 999999", top.getReturnValue(), oneMillion - 1);

        stack.pop();

        top = stack.top();
        assertEquals("top should be 999998", top.getReturnValue(), oneMillion - 2);

        ReturnObject pop;

        for (int i = oneMillion - 2; i >= 0; i--) {
            pop = stack.pop();
            assertEquals("pop should equal correct value", pop.getReturnValue(), i);
        }

        assertTrue("stack should be empty", stack.isEmpty());
        assertEquals("stack should have size 0", stack.size(), 0);

        top = stack.top();

        assertTrue("top should have an error", top.hasError());
        assertEquals("top should return empty structure error", top.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("top should return null as value", top.getReturnValue());

        pop = stack.pop();

        assertTrue("pop should have an error", pop.hasError());
        assertEquals("pop should return empty structure error", pop.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("pop should return null as value", pop.getReturnValue());
    }

    @Test
    public void testImprovedStackRemove() {
        ImprovedStack stack = new ImprovedStackImpl(new ArrayList());
        int oneFiftyK = 150000;
        int seventyFiveK = oneFiftyK / 2;
        String stringOdd = "Test string " + 1;
        String stringEven = "Test string " + 2;

        for (int i = 0; i < oneFiftyK; i++) {
            if (i % 2 == 0) {
                stack.push(stringEven);
            } else {
                stack.push(stringOdd);
            }
        }

        assertEquals("stack should have 150k items",
                stack.size(), oneFiftyK);

        assertFalse("stack should not be empty",
                stack.isEmpty());

        stack.remove(stringEven);

        assertEquals("stack should now have 75k items",
                stack.size(), seventyFiveK);

        stack.remove(stringOdd);

        assertEquals("stack should now have 0 items",
                stack.size(), 0);

        assertTrue("stack should be empty",
                stack.isEmpty());

        stack.remove(stringEven);
        stack.remove(stringOdd);

        assertEquals("stack should still have 0 items",
                stack.size(), 0);

        assertTrue("stack should still be empty",
                stack.isEmpty());

        ReturnObject top = stack.top();

        assertTrue("top should have an error", top.hasError());
        assertEquals("top should return empty structure error", top.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("top should return null as value", top.getReturnValue());

        ReturnObject pop = stack.pop();

        assertTrue("pop should have an error", pop.hasError());
        assertEquals("pop should return empty structure error", pop.getError(), ErrorMessage.EMPTY_STRUCTURE);
        assertNull("pop should return null as value", pop.getReturnValue());
    }

    @Test
    public void testImprovedStackReverse() {
        ImprovedStack stack = new ImprovedStackImpl(new ArrayList());
        int oneMillion = 1000000;

        for (int i = 0; i < oneMillion; i++) {
            stack.push(i + 1);
        }

        assertEquals("stack should have one million items",
                stack.size(), oneMillion);

        assertFalse("stack should not be empty",
                stack.isEmpty());

        ImprovedStack reverse = stack.reverse();

        assertEquals("stack should have one million items",
                stack.size(), oneMillion);

        assertFalse("stack should not be empty",
                stack.isEmpty());

        assertEquals("stack top should equal one million",
                stack.top().getReturnValue(), oneMillion);

        assertEquals("reverse should have one million items",
                reverse.size(), oneMillion);

        assertEquals("reverse top should equal one",
                reverse.top().getReturnValue(), 1);
    }
}
