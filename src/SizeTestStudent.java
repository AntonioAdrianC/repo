import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SizeTestStudent 
{

	@Test
	void testSize() 
	{
		assertFalse(Size.SMALL == Size.LARGE);
		assertTrue(Size.MEDIUM == Size.MEDIUM);
	}

}
