package net.xpdeveloper.pocketwatch;

/**
 * Implementors should use the milliseconds from Jan 1 1970 Epoch
 * @author obye
 * 
 */
public interface ClockMechanism {

	/**
	 * 
	 * @return milliseconds since 00:00:00 Jan 1 1970
	 */
	public long currentTimeMillis();

}
