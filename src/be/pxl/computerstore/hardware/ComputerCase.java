package be.pxl.computerstore.hardware;

import java.util.Random;

import be.pxl.computerstore.util.Dimension;

public class ComputerCase {

	private String vendor = "";
	private String name;
	private double price;
	private Dimension dimension;
	private double weight;

	private String articleNumber = "";

	private Random rand = new Random();
	private int randomNumber1 = 1;
	private String randomNrString1 = "";

	private int randomNumber2 = 1;
	private String randomNrString2 = "";

	private String zeroes = "";
	private String xes = "";

	public ComputerCase(String vendor, String name, double price) {
		this.vendor = vendor;
		this.name = name;
		this.price = price;
		this.articleNumber = generateArticleNumber();
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public be.pxl.computerstore.util.Dimension getDimension() {
		return dimension;
	}

	public void setDimension(be.pxl.computerstore.util.Dimension dimension) {
		this.dimension = dimension;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	private String generateArticleNumber() {
		if (vendor.length() > 3) {
			articleNumber = vendor.substring(0, 3).toUpperCase();
		} else {
			for (int i = 0; i < (3 - vendor.length()); i++) {
				xes += "X";
			}
			articleNumber = vendor.toUpperCase() + xes;
		}
		articleNumber += "-";

		randomNumber1 = rand.nextInt((100000 - 1) + 1) + 1;
		randomNrString1 = String.valueOf(randomNumber1);

		if (randomNrString1.length() < 5) {
			for (int i = 0; i < (5 - randomNrString1.length()); i++) {
				zeroes += "0";
			}
			randomNrString1 = zeroes + randomNrString1;
		}
		articleNumber += randomNrString1 + "-";

		for (int i = 0; i < 3; i++) {
			randomNumber2 = rand.nextInt((9 - 1) + 1) + 1;
			randomNrString2 += String.valueOf(randomNumber2);
		}
		articleNumber += randomNrString2;
		return articleNumber;
	}

	@Override
	public String toString() {
		return "ArticleNumber = " + getArticleNumber() + "\nVendor = " + getVendor() + "\nName = " + getName()
		+ "\nPrice = " + getPrice() + "\nWidth = " + getDimension().getWidth() + "mm\nHeight = " + getDimension().getHeight()
		+ "mm\nDepth = " + getDimension().getDepth() + "mm\nWeight = " + getWeight() + "kg";
	}

	public String getShortDescription() {
		return getArticleNumber() + " * " + getClass().getSimpleName() + " * " + getPrice() + "€";
	}

}
