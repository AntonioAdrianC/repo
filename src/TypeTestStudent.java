import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TypeTestStudent 
{

	@Test
	void testType() 
	{
		assertTrue(Type.ALCOHOL == Type.ALCOHOL);
		assertFalse(Type.COFFEE == Type.SMOOTHIE);
	}

}
