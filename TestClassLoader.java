package functions;

public class TestClassLoader {

	public static void main(String[] args) {

		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("me");
				
			}
		});
		
		System.out.println(ClassLoader.getSystemClassLoader().toString());
				
	}

}
