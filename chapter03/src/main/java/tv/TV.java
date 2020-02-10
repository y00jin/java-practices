package tv;

public class TV {
	private int channel;
	private int volume;
	private boolean power;

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}

	public void power(boolean on) {
		if (on == true)
			this.power = true;
		else
			this.power = false;
	}

	public void channel(int channel) {
		// 1~255 유지
		if (!power)
			return;

		if (channel < 1) {
			this.channel = 255;
		} else if (channel > 255) {
			this.channel = 1;
		} else {
			this.channel = channel;
		}

	}

	public void channel(boolean up) {
		// 1~255 유지, 1씩 증감
//		if(up == true) {
//			this.channel += 1;
//			channel(this.channel);
//		}
		channel(channel + (up ? 1 : -1));
	}

	public void volume(int volume) {
		// 1~255 유지
		if (!power)
			return;

		if (volume < 1) {
			this.volume = 1;
		} else if (volume > 255) {
			this.volume = 255;
		} else {
			this.volume = volume;
		}
	}

	public void volume(boolean up) {
		// 1~255 유지, 1씩 증감
//		if(up == true) {
//			this.volume += 1;
//			volume(this.volume);
//		} else {
//			this.volume += 1;
//			volume(this.volume);
//		}
		volume(volume + (up ? 1 : -1));
	}

	public void status() {
		System.out.println("TV[channel=" + channel + ", volume=" + volume + ", power = " + power + "]");
	}

}
