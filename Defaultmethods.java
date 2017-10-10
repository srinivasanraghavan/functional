package functions;

/**
 * 
 * @author srinirag
 * 
 * 
 *         Default methods can help you add a functionality without breaking
 *         client code 
 * 
 *         The example gives the working of the default methods
 * 
 * 
 *         Default methods can be overridden
 * 
 * 
 *         support multiple inheritance but without ambiguity
 * 
 * 
 * 
 * 
 *
 */

interface i1 {

	public void dothis();

	default void dothisalso() {
		System.out.println("I am doing this also ");
	}
	
}

interface i2 {

	public void dothat();

	default void dothatalso() {
		System.out.println("I am doing that also ");
	}
}

public class Defaultmethods implements i1, i2 {

	@Override
	public void dothat() {
		System.out.println("I am doing that");
	}

	@Override
	public void dothis() {

		System.out.println("I am doing this");
	}

	
	
}
