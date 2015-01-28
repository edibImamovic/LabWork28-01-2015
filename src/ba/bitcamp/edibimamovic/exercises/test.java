package ba.bitcamp.edibimamovic.exercises;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class test {

	public static void main(String[] args) {

		Person p1 = new Person("Edib", "Imamovic");
		Person p2 = new Person("Jesenko", "Gavric");
		Person p3 = new Person("Adnan", "Spahic");
		Person p4 = new Person("Gorjan", "Kalauzovic");
		Person p5 = new Person("Benjamin", "Talic");
		Person p6 = new Person("Hikmet", "Durgutovic");

		p1.addChild(new Person("Jesenko"));
		p2.addChild(new Person("Jesenko"));
		p3.addChild(new Person("Jesenko"));
		p6.addChild(new Person("SekaAleksic"));
		LinkedList<Person> ls = new LinkedList<Person>();
		ls.add(p1);
		ls.add(p2);
		ls.add(p3);
		ls.add(p4);
		ls.add(p5);
		ls.add(p6);
		System.out.println(ls.toString());

		try {
			Person.personToXML(ls,
					new FileOutputStream("./FileXML/NewFile.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
