import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CalculateService {
	private LocalDateTime now;
	private LocalDateTime birthDay;
	
	private long months;
	private long weeks;
	private long hours;
	private long minutes;
	private long seconds;
	
	
	public CalculateService(LocalDateTime now,LocalDateTime birthDay ) {
		this.now = now;
		this.birthDay = birthDay;
		
	    months = birthDay.until(now, ChronoUnit.MONTHS);
	    weeks = birthDay.until(now, ChronoUnit.WEEKS);
	    hours = birthDay.until(now, ChronoUnit.HOURS);
	    minutes = birthDay.until(now, ChronoUnit.MINUTES);	    
	    seconds = birthDay.until(now, ChronoUnit.SECONDS);
	}


	public long getMonths() {
		return months;
	}


	public void setMonths(long months) {
		this.months = months;
	}


	public long getWeeks() {
		return weeks;
	}


	public void setWeeks(long weeks) {
		this.weeks = weeks;
	}


	public long getHours() {
		return hours;
	}


	public void setHours(long hours) {
		this.hours = hours;
	}


	public long getMinutes() {
		return minutes;
	}


	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}


	public long getSeconds() {
		return seconds;
	}


	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}
	
}
