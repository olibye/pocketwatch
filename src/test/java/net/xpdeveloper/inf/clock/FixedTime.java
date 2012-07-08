package net.xpdeveloper.inf.clock;

import java.util.Date;

/**
 * I always return the same time, this is useful for matching test data
 * @author obye
 *
 */
public class FixedTime implements ClockMechanism {
	private Date _fixedNow;
	
	/**
	 * Note that if you're using the deprecated java.util.Date(year,month,day) constructor
	 * You have to specify the year - 1900 e.g. 1972 is just 72
	 * @param fixedDateTime
	 */
	public FixedTime(Date fixedDateTime) {
		_fixedNow = fixedDateTime;
	}

	
	public long currentTimeMillis() {
		return _fixedNow.getTime();
	}

}
