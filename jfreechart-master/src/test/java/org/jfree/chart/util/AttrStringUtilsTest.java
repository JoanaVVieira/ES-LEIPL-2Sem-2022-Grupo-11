package org.jfree.chart.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.awt.geom.Rectangle2D;
import org.junit.jupiter.api.Test;

/**
 * Tests for the {@link AttrStringUtils } class.
 */

public class AttrStringUtilsTest {

	/**
	 * Tests to test exceptions
	 * 
	 */
	 @Test
	public void testAttrStringUtilsExceptions() {
	    assertThrows(NullPointerException.class, ()->{
	    	Rectangle2D t1 = AttrStringUtils.getTextBounds(null, null);
	    });
	    
	    assertThrows(IllegalArgumentException.class, ()->{
	    	AttrStringUtils.drawRotatedString(null, null, 0, 0, 0);
	    });
	    
	    assertThrows(IllegalArgumentException.class, ()->{
	    	AttrStringUtils.drawRotatedString(null, null, 0, 0, 0, 0, 0);
	    });
	    
	    assertThrows(IllegalArgumentException.class, ()->{
	    	AttrStringUtils.drawRotatedString(null, null, 0, 0, null, 0, 0, 0);
	    });
	    
	    assertThrows(IllegalArgumentException.class, ()->{
	    	AttrStringUtils.drawRotatedString(null, null, 0, 0, null, 0, null);
	    });
	}
}
