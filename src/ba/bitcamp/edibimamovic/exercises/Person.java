package ba.bitcamp.edibimamovic.exercises;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Person {

	private String name;
	private String lastName;
	private LinkedList<Person> children;

	public Person(String name, String lastName) {
		super();
		this.name = name;
		this.lastName = lastName;
		children = new LinkedList<>();

	}

	public Person(String name) {
		this.name = name;
		children = new LinkedList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person name: " + name + " LastName: " + lastName + "Children:"
				+ children + "\n";
	}

	public static void personToXML(List<Person> persons, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<people>");
		Iterator<Person> it = persons.iterator();
		Person tmp = null;
		while (it.hasNext()) {
			tmp = it.next();
			pw.println(" <person name ='" + tmp.name + "' " + "lastName = '"
					+ tmp.lastName + "'>");

			Iterator<Person> itC = tmp.children.iterator();
			Person tmpC = null;
			while (itC.hasNext()) {

				tmpC = itC.next();
				pw.println(" <child name ='" + tmpC.name + "' "
						+ "lastName = '" + tmp.lastName + "'/>");
			}
			pw.println("</person>");
		}

		pw.println("</people>");
		pw.flush();
	}

	public void addChild(Person p) {
		children.add(p);
	}

}
