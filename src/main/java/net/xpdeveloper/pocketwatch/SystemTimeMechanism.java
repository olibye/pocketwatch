package net.xpdeveloper.pocketwatch;


/**
 * Use Java system time as the implementation.
 * @author obye
 *
 */
public class SystemTimeMechanism implements ClockMechanism {

	/**
	 * @return System.currentTimeMillis();
	 */
	public long currentTimeMillis() {
		return System.currentTimeMillis();
	}

}
