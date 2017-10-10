package functions;

public class DecoratorPattern {

	static abstract class Beverage {

		String description = "Unknown Beverage";

		public String getDescription() {
			return description;
		}

		abstract double cost();

	}

	static public abstract class CondimentDecorator extends Beverage {

		public abstract String getDescription();

	}

	static public class Espresso extends Beverage {
		public Espresso() {
			description = "Espresso";
		}

		public double cost() {
			return 1.99;
		}
	}

	static public class HouseBlend extends Beverage {
		public HouseBlend() {
			description = "House Blend Coffee";
		}

		public double cost() {
			return .89;
		}
	}

	static public class Mocha extends CondimentDecorator {
		Beverage beverage;

		public Mocha(Beverage beverage) {
			this.beverage = beverage;
		}

		public String getDescription() {
			return beverage.getDescription() + ", Mocha";
		}

		public double cost() {
			return beverage.cost() + .20;
		}
	}

	public static void main(String[] args) {

		Beverage beverage = new Espresso();
		beverage = new Mocha(beverage);
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);

		System.out
				.println(beverage2.getDescription() + " $" + beverage2.cost());

	}

}
