package functions;

public class BuilderPatternNotUsed {
	static class Mailer {
		public void from(final String address) { /* ... */
		}

		public void to(final String address) { /* ... */
		}

		public void subject(final String line) { /* ... */
		}

		public void body(final String message) { /* ... */
		}

		public void send() {
			System.out.println("sending...");
		}

	}

	// ...
	public static void main(final String[] args) {
		Mailer mailer = new Mailer();
		mailer.from("build@oracle.com");
		mailer.to("srinivasan.raghavan@oracle.com");
		mailer.subject("build notification");
		mailer.body("...your code sucks...");
		mailer.send();

	}
}
