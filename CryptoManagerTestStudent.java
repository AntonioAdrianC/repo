
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() 
	{
		assertTrue(CryptoManager.isStringInBounds("AMAZING"));
		assertTrue(CryptoManager.isStringInBounds("NO WAY THIS IS NOT BUTTER"));
		assertFalse(CryptoManager.isStringInBounds("te amo"));
		assertFalse(CryptoManager.isStringInBounds("@>?IM EMO$^_\\d"));
		assertFalse(CryptoManager.isStringInBounds("FAILING TIME. {}|~`"));
	}

	@Test
	public void testEncryptCaesar() 
	{
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("{{{", 3));
		assertEquals("N%QNPJ%YT%XPFYJ", CryptoManager.caesarEncryption("I LIKE TO SKATE", 5));
		assertEquals("5L0;:S@L8571L133?", CryptoManager.caesarEncryption("I DON'T LIKE EGGS", 300));
		assertEquals("UFTU/!UFTUJOH", CryptoManager.caesarEncryption("TEST. TESTING", 1));
	}

	@Test
	public void testDecryptCaesar() 
	{
		assertEquals("TIME TO DECRYPT", CryptoManager.caesarDecryption("UJNF!UP!EFDSZQU", 1));
		assertEquals("DECRYPTING STRING", CryptoManager.caesarDecryption("$%#2904).'@342).'", 800));
		assertEquals("LOVE BEADADOBEE", CryptoManager.caesarDecryption("\"%,[6X[WZWZ%X[[", 22));
		assertEquals("LAST ONE", CryptoManager.caesarDecryption("0%78D32)", 100));
	}

	@Test
	public void testEncryptBellaso() 
	{
		assertEquals("S\"ZF$@^T.,)\\3,\\''MH]VYP[L'TV]PL5", CryptoManager.bellasoEncryption("PIXAR SOUL IS MY FAVORITE MOVIE.", "CYBER KEY IS LONGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG"));
		assertEquals("Q)](O(\\)$'PX(Q(0!UW),$BUMK(ZSE", CryptoManager.bellasoEncryption("I DON'T KNOW HOW TO SKATEBOARD", "HIYYAA"));
		assertEquals("#I\"4)'%UY,RPQ7JT,UT", CryptoManager.bellasoEncryption("LAST TEST FOR BELLA", "WHO IS BELLA?"));

	}

	@Test
	public void testDecryptBellaso() 
	{
		assertEquals("CUPCAKES AND BEER", CryptoManager.bellasoDecryption("F.RHS_J+4!WW@NTSY", "CYBERTEXT IS LONGERRRRRRRR"));
		assertEquals("CHRISTMAS IS AMAZING", CryptoManager.bellasoDecryption("STS\"3W&CX2Y(.L-3J@EW", "PLAY CYBERPUNK 2077"));
		assertEquals("LAST TEST FOR BELLA DECRYPTION", CryptoManager.bellasoDecryption(" F&()\"L'Y3ZX 'VJ_ J.KYH%-Y\"P#S", "TESTING"));

	}
	@Test
	public void testGetASCIIMAP()
	{
		assertFalse(CryptoManager.getASCIIMAP().isEmpty());
		assertTrue(CryptoManager.getASCIIMAP().size() == CryptoManager.RANGE);

	}

}
