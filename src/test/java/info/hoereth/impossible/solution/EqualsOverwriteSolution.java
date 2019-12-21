package info.hoereth.impossible.solution;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class EqualsOverwriteSolution {

	/**
	 * The problem with {@link Person} was that it broke Java's "equals contract":
	 * WHENEVER TWO OBJECTS ARE EQUAL, THEIR HASH CODES MUST ALSO BE THE SAME. What
	 * is it good for? Just imagine how {@link HashSet#add(Object)} works
	 * internally. The equals method might be very costly for complex object,
	 * whereas the hashCode method should be cheap. The HashSet only calculates the
	 * hashCode initially. If this is different to all other elements' hashCodes,
	 * the object will be added. Only if there is a "hashCode collision", an equals
	 * comparison must be performed to double check equality. But only for those two
	 * objects with equal hash codes. You can see how this boosts the performance,
	 * but can only work for valid "equals/hashCode" implementations.
	 */
	@Test
	public void add_to_hashset() {
		Person a = new Person("Jonny", "Depp");
		Person b = new Person("Jonny", "Depp");

		Assert.assertEquals(a, b);

		Set<Person> set = new HashSet<>();
		set.add(a);
		set.add(b);

		Assert.assertEquals(1, set.size());
	}

	public class Person {
		public final String firstName, lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		@Override
		public boolean equals(Object other) {
			if (other instanceof Person) {
				Person otherPerson = (Person) other;
				return firstName.equals(otherPerson.firstName) && lastName.equals(otherPerson.lastName);
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			return firstName.hashCode() + 13 * lastName.hashCode();
		}
	}
}
