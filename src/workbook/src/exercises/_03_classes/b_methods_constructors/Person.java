package exercises._03_classes.b_methods_constructors;

/** Class representing a natural person.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Person {
	String firstName;
	String surname;
	
	Person(String firstName, String surname) {
		super();
		this.firstName = firstName;
		this.surname = surname;
	}

	String getFirstName() {
		return firstName;
	}

	String getSurname() {
		return surname;
	}
	
	String getFullName() {
		return firstName + " " + surname;
	}
}
