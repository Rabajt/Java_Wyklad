import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StackTest
{
	private Stack sut;

	@Before
	public void Setup ()
	{
		sut = new Stack(13);
	}

	@Test
	public void TestIfCanCreateSut ()
	{
		assertNotEquals("Stack is not null", null , sut);
	}


	@Test
	public void TestTrueEmptyStack ()
	{
		assertEquals("Stack is empty", true, sut.isEmpty());
	}

	@Test
	public void TestFalseEmptyStack ()
	{
		sut.push(1);
		assertEquals("Stack is not empty", false, sut.isEmpty());
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestPeekOnEmptyStack ()
	{
		sut.peek();
	}

	@Test
	public void TestPopAfterPushAndDropOfElement ()
	{
		sut.push(10);
		int result = sut.pop();
		boolean result2 = sut.isEmpty();
		assertEquals("Pop after push", 10, result);
		assertEquals("Stack is empty", true, result2);
	}

	@Test
	public void TestPeekAfterPush ()
	{
		sut.push(13);
		int result = sut.peek();
		assertEquals("Peek after push", 13, result);
	}

	@Test
	public void TestDoublePushAndPeek ()
	{
		sut.push(4);
		sut.push(1);
		int result = sut.peek();
		assertEquals("Peek after double push", 1, result);
	}

	@Test
	public void TestDoublePushAndPop ()
	{
		sut.push(2);
		sut.push(3);
		sut.pop();
		int result = sut.pop();
		assertEquals("Pop after double push", 2, result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void TestDoublePopAfterSinglePush ()
	{
		sut.push(1);
		sut.pop();
		sut.pop();
	}

	@Test
	public void TestFirstElementPopAfterhundredPushes ()
	{
		for (int j = 0; j < 100; j++) {
			sut.push(j);
		}
		int result = -1;
		for (int j = 0; j < 100; j++) {
			result = sut.pop();
		}
		assertEquals("Pop of first element from stack of 100 elements", 0, result);
	}

	@Test
	public void TestPenultimateElementPopAfterhundredPushes ()
	{
		for (int j = 0; j < 100; j++) {
			sut.push(j);
		}
		int result = -1;
		for (int j = 0; j < 1; j++) {
			result = sut.pop();
		}
		assertEquals("Pop of penultimate element from stack of 100 elements", 99, result);
	}
}
