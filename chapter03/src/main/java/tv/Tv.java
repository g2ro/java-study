package tv;

// channel : 1-255
// volume : 1-100
public class Tv {
	private int channel;
	private int volume;
	private boolean power;
	
	public void status() {
		System.out.println("TV[channel=" + channel +
				", volumne=" + volume + 
				", power=" + (power? "on" : "off") + "]");
	}
	
	public Tv(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
	
	
	public void power(boolean power) {
		this.power = power;
	}

	// volumn조정
	private int volumeReset(int i) {
		if(i > 100) {
			i = 0;
		}
		else if(i < 0) {
			i = 100;
		}
		
		return i;
	}
	
	public void volume(int i) {
		this.volume = i;
		this.volume = volumeReset(this.volume);
	}
	
	public void volume(boolean b) {
		if(b) {
			this.volume += 1;
		}
		else {
			this.volume -= 1;
		}
		this.volume = volumeReset(this.volume);
	}
	
	
	
	// channel 조정
	
	private int channelReset(int i) {
		if(i > 255) {
			i = 1;
		}
		else if(i <= 0) {
			i = 255;
		}
		
		return i;
	}
	
	
	public void channel(int i) {
		this.channel = i;
		this.channel = channelReset(this.channel);
	}
	
	public void channel(boolean b) {
		
		if(b) {
			this.channel += 1;
		}
		else {
			this.channel -= 1;
		}
		
		this.channel = channelReset(this.channel);
	}
	
}
