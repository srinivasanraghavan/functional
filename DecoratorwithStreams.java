package functions;

/**
 * @author srinirag
 * 
 */
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * 
 * @author srinirag
 *
 */

@SuppressWarnings("unchecked")
public class DecoratorwithStreams {

	static private class Beverage {

		private Function<String, String> desciption;

		private Function<Double, Double> cost;

		public Beverage() {
			setCosts();
			setDescription();

		}

		public Double getCost(double cost) {

			return this.cost.apply(cost);
		}

		public String getDescription(String desciption) {

			return this.desciption.apply(desciption);
		}

		public void setCosts(Function<Double, Double>... addOns) {

			this.cost = Stream.of(addOns)
					.reduce((cost, next) -> cost.andThen(next))
					.orElse((cost) -> cost);

		}

		public void setDescription(Function<String, String>... addOns) {

			this.desciption = Stream.of(addOns)
					.reduce((desciption, next) -> desciption.andThen(next))
					.orElse((desciption) -> desciption);

		}

	}

	public static void main(final String[] args) {

		Beverage beverage = new Beverage();
		beverage.setCosts((cost) -> cost + 3, (cost) -> cost + 1);

		System.out.println(beverage.getCost(1));

		beverage.setDescription((desciption) -> desciption + "mocha", (
				desciption) -> desciption + "  whip");

		System.out.println(beverage.getDescription("Plain cofee .. "));

	}
}
