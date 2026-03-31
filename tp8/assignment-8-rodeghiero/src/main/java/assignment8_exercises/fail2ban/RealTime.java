package assignment8_exercises.fail2ban;

import java.io.Serializable;

public class RealTime implements ITime, Serializable {

	public  static final long serialVersionUID = 1;
	public long getCurrentTime() {
		return System.currentTimeMillis();
	}

	
}
