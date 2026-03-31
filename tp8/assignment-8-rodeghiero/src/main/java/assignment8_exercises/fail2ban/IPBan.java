package assignment8_exercises.fail2ban;

import java.io.Serializable;

public class IPBan implements Serializable {

	public static final long serialVersionUID = 1;
	/**
	 * The banned ip
	 */
	public IP ip;
	/**
	 * Creations time stamp
	 */
	public Long expires;
	
	public IP getIp() {
		return ip;
	}
	public void setIp(IP ip) {
		this.ip = ip;
	}
	public Long getExpires() {
		return expires;
	}
	public void setExpires(Long ts) {
		this.expires = ts;
	}
	public IPBan(IP ip, Long ts) {
		super();
		this.ip = ip;
		this.expires = ts;
	}	

	@Override
	public String toString() {
		return "IPBan [ip=" + ip + ", expires=" + expires + "]";
	}	


}
