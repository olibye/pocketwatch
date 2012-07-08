package net.xpdeveloper.pocketwatch;

/**
 * I'm used to provide a thin interface to time. Sometimes we want Java system
 * time Sometimes we want database time. Sometimes we want to simulate a
 * specific time (e.g. unit tests). Sometimes we want to simulate a specific
 * time offset from realtime (e.g. if we've got previous test data from
 * production that relates to a specific time)
 * 
 * The default is Java System.currentTimeMillis If we're really concerned about
 * timezones for other implementations, the default implementation implies that
 * the time zone is that of the JVM.
 * 
 * This should be taken into consideration if users are sensitive to timezones.
 * 
 * @author obye
 * 
 */
public class Clock {
	private static ClockMechanism _mechanism = new SystemTimeMechanism();

	/**
	 * 
	 * @return milliseconds since 00:00:00 Jan 1 1970 Epoch
	 */
	public static long currentTimeMillis() {
		return _mechanism.currentTimeMillis();
	}

	/**
	 * Override the default SystemTime implementation. This obviously takes
	 * effect for the scope of the ClassLoader that loaded Clock
	 * 
	 * @param aTimeMechanism
	 */
	public static void setTime(ClockMechanism aTimeMechanism) {
		_mechanism = aTimeMechanism;
	}

	public static java.util.Date utilDate() {
		return new java.util.Date(currentTimeMillis());
	}

}
