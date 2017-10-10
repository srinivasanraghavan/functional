package functions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Reference to a static method Containing Class::staticMethodName ; Reference
 * to an instance method of a particular object containing
 * Object::instanceMethodName ; Reference to an instance method of an arbitrary
 * object of a particular type ContainingType::methodName ; Reference to a
 * constructor ClassName::new;
 * 
 * @author srinirag
 *
 */

public class MethodReferences {

	static int compareme(String a, String b) {

		return a.compareTo(b);

	}

	static class Mycompare {

		public int compareme(String o1, String o2) {

			return o1.compareTo(o2);
		}

	}

	static Set<String> transformIntoSet(List<String> strings,
			Supplier<Set<String>> supplier) {

		Set<String> dest = supplier.get();
		for (String string : strings) {
			dest.add(string);
		}
		return dest;
	}

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Adam", "Srini", "Dan", "Chris",
				"Govind");

		// Reference to a static method ContainingClass::staticMethodName

		names.sort(MethodReferences::compareme);
		System.out.println(names);

		/**
		 * Reference to an instance method of a particular object containingObject::instanceMethodName
		 */

		Mycompare mycompare = new Mycompare();

		names.sort(mycompare::compareme);

		System.out.println(names);

		/**
		 * Reference to an instance method of an arbitrary object of a particular type ContainingType::methodName
		 * 
		 * names.sort((a,b) -> a.compareToIgnoreCase(b));
		 */

		names.sort(String::compareToIgnoreCase);

		System.out.println(names);

		/**
		 * Reference to a constructor ClassName::new
		 * 
		 * Set<String> nameSet = transformIntoSet(names, () ->{ return new
		 * HashSet<>();});
		 */

		Set<String> nameSet = transformIntoSet(names, HashSet<String>::new);

		System.out.println(nameSet);
	}
}
