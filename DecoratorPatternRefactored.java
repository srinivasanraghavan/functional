package functions;

/**
 * @author srinirag
 * 
 * Explains the decorator pattern
 */

import java.util.Objects;
import java.util.function.Function;

@SuppressWarnings("unchecked")
public class DecoratorPatternRefactored {
	static class Beverage {

		Function<String, String> desciption;

		Function<Double, Double> cost;

		public Beverage() {
			decorateCosts();
			decorateDescription();

		}

		public Double getCost(double cost) {

			return this.cost.apply(cost);
		}

		public String getDescription(String desciption) {

			return this.desciption.apply(desciption);
		}

		public void decorateCosts(Function<Double, Double>... addOns) {

			if (Objects.isNull(this.cost)) {

				this.cost = (cost) -> cost;

			} else {
				for (Function<Double, Double> addOn : addOns)
					this.cost = this.cost.andThen(addOn);
			}

		}

		public void decorateDescription(Function<String, String>... addOns) {

			if (Objects.isNull(this.desciption)) {

				this.desciption = (desciption) -> desciption;

			} else {
				for (Function<String, String> addOn : addOns)
					this.desciption = this.desciption.andThen(addOn);
			}

		}

	}

	public static void main(final String[] args) {

		Beverage beverage = new Beverage();
		beverage.decorateCosts((cost) -> cost + 3, (cost) -> cost + 1);

		System.out.println(beverage.getCost(1));

		beverage.decorateDescription((desciption) -> desciption + "mocha", (
				desciption) -> desciption + "  whip");

		System.out.println(beverage.getDescription("Plain cofee .. "));

	}
}
