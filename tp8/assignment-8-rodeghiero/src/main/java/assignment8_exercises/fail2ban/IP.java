package assignment8_exercises.fail2ban;

import java.io.Serializable;

public class IP implements Serializable {

	public  static final long serialVersionUID = 1;
	private Integer first;
	public Integer getFirst() {
		return first;
	}


	public void setFirst(Integer first) {
		this.first = first;
	}


	public Integer getSecond() {
		return second;
	}


	public void setSecond(Integer second) {
		this.second = second;
	}


	public Integer getThird() {
		return third;
	}


	public void setThird(Integer third) {
		this.third = third;
	}


	public Integer getFourth() {
		return fourth;
	}


	public void setFourth(Integer fourth) {
		this.fourth = fourth;
	}


	private Integer second;
	private Integer third;
	private Integer fourth;
	
	
	public IP(Integer first, Integer second, Integer third, Integer fourth) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}


	@Override
	public String toString() {
		return first + "." + second + "." + third
				+ "." + fourth;
	}


	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((fourth == null) ? 0 : fourth.hashCode());
		result = prime * result + ((second == null) ? 0 : second.hashCode());
		result = prime * result + ((third == null) ? 0 : third.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IP other = (IP) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (fourth == null) {
			if (other.fourth != null)
				return false;
		} else if (!fourth.equals(other.fourth))
			return false;
		if (second == null) {
			if (other.second != null)
				return false;
		} else if (!second.equals(other.second))
			return false;
		if (third == null) {
			if (other.third != null)
				return false;
		} else if (!third.equals(other.third))
			return false;
		return true;
	}
	
	
	
	
	
}
