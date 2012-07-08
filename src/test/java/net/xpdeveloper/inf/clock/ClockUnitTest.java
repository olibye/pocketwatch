package net.xpdeveloper.inf.clock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ClockUnitTest {
	
	@Test
	public void checkDefaultWallClockMilliseconds() {
		
		long systemNow = System.currentTimeMillis();
		Clock.setTime(new SystemTimeMechanism());
		long unitNow = Clock.currentTimeMillis();
		
		assertTrue("Should default to wall clock time",Math.abs((unitNow - systemNow)) < 100);
	}
	
	@Test
	public void checkFixedTime() {
		Date expectedDate = fixedDate();
		Clock.setTime(new FixedTime(expectedDate));
		long unitNow = Clock.currentTimeMillis();
		
		assertEquals("Wrong time",expectedDate.getTime(),unitNow);		
	}

	@Test
	public void checkUtilDate() {
		Date expectedDate = fixedDate();
		Clock.setTime(new FixedTime(expectedDate));
		java.util.Date unitNow = Clock.utilDate();
		
		assertEquals("Should default to wall clock time",expectedDate.getTime(),unitNow.getTime());				
	}

	private Date fixedDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1972,07-1,24); // because java uses zero month offset ;-)
		return calendar.getTime();
	}
}
