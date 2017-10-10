package functions;

/**
 * 
 * This is a piece of code that illustrate how lambdas work in Java 8
 * 
 * Given an example
 * 
 * f(x) = 2x+5;
 * 
 * given x= 2 ; f(x) = 9 ;
 * 
 * z(x)= f(g(x)) where g(x) =3x+5
 * 
 * z(x) = 2(3x+5) +5 = 6x+15 12+15 = 27
 * 
 * @author srinirag
 *
 */

@FunctionalInterface                                                                                                                                                                                                                                                                                                                                                                                                                                         
interface Funct<T, R> {

	R apply(T x);

	default <V> Funct<V, R> compose(Funct<V, T> before) {
		return (V x) -> apply(before.apply(x));
	}
}

public class LambdaUnderStanding1 {

	public static void main(String[] args) {

		Funct<Integer, Integer> funct = (x) -> 2 * x + 5;

		System.out.println(funct.apply(2));

		Funct<Integer, Integer> composed = funct.compose((x) -> 3 * x + 5);

		System.out.println(composed.apply(2));
	}
}
