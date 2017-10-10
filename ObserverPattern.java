package functions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ObserverPattern {

	static interface Observable {
		public void registerObserver(Observer o);

		public void removeObserver(Observer o);

		public void notifyObservers();
	}

	@FunctionalInterface
	static interface Observer {
		public void update(Object args1, Object args2, Object args3);
	}

	static interface DisplayElement {
		public void display();
	}

	static class ObservableImpl implements Observable {

		final List<Observer> observers;

		Object args1;
		Object args2;
		Object args3;

		public ObservableImpl() {
			observers = new ArrayList<>();
		}

		@Override
		public void registerObserver(Observer o) {
			observers.add(o);

		}

		@Override
		public void removeObserver(Observer o) {
			observers.remove(o);

		}

		@Override
		public void notifyObservers() {

			for (Observer observer : observers) {
				observer.update(args1, args2, args3);
			}

		}

		public void updateData(Object args1, Object args2, Object args3) {

			this.args1 = args1;
			this.args2 = args2;
			this.args3 = args3;
			notifyObservers();

		}

	}

	public static void main(String[] args) {

		ObservableImpl observable = new ObservableImpl();

		observable.registerObserver(new Observer() {

			@Override
			public void update(Object args1, Object args2, Object args3) {

				System.out.println(args1.toString() + args2.toString()
						+ args3.toString());
			}
		});

		observable.updateData(new Object(), new Object(), new Object());

		observable.registerObserver((a1, a2, a3) -> System.out.println(a1
				.toString() + a2.toString() + a3.toString()));

	}
}
