package info.hoereth.impossible;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import info.hoereth.impossible.solution.EqualsOverwriteSolution;

public class EqualsOverwrite {

	/**
	 * {@link Person#equals(Object)} has been overwritten. a and b are equal => only
	 * one instance should be added to the set. Why is the set ending up with 2
	 * elements?
	 * 
	 * @see EqualsOverwriteSolution#add_to_hashset()
	 */
	@Test
	public void add_to_hashset() {
		Person a = new Person("Jonny", "Depp");
		Person b = new Person("Jonny", "Depp");

		Assert.assertEquals(a, b);

		Set<Person> set = new HashSet<>();
		set.add(a);
		set.add(b);

		Assert.assertEquals(2, set.size());
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
	}
}
