package be.pxl.computerstore.hardware;

public class Processor extends ComputerCase {

	private double clockspeed;

	public Processor(String vendor, String name, double price, double clockspeed) {
		super(vendor, name, price);
		setClockspeed(clockspeed);
	}

	public double getClockspeed() {
		return clockspeed;
	}

	public void setClockspeed(double clockspeed) {

		if (clockspeed < 0.7) {
			this.clockspeed = 0.7;
		} else {
			this.clockspeed = clockspeed;
		}
	}
	
	@Override
	public String toString() {
		return "ArticleNumber = " + super.getArticleNumber() + "\nVendor = " + super.getVendor() + "\nName = " + super.getName()
				+ "\nPrice = " + super.getPrice() + "\nClock speed = " + getClockspeed() + "GHz";
	}
	
}
