package functions;

import java.util.function.Consumer;

public class BuilderPatternRefactored {
	static class Mailer {
		private Mailer() {
		}

		public Mailer from(final String address) { /* ... */
			;
			return this;
		}

		public Mailer to(final String address) { /* ... */
			;
			return this;
		}

		public Mailer subject(final String line) { /* ... */
			;
			return this;
		}

		public Mailer body(final String message) { /* ... */
			;
			return this;
		}

		public static void send(final Consumer<Mailer> block) {
			final Mailer mailer = new Mailer();
			block.accept(mailer);
			System.out.println("sending...");
		}

		// ...
	}

	public static void main(final String[] args) {

		Mailer.send(mailer -> mailer.from("build@oracle.com")
				.to("srinivasan.raghavan@oracle.com").subject("build notification")
				.body("...much better..."));
	}

}
