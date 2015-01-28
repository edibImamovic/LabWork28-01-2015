package ba.bitcamp.edibimamovic.exercises;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonReader {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();

		Document xmldoc = docReader.parse(new File("./FileXML/people.xml"));

		NodeList xmlPeople = xmldoc.getElementsByTagName("person");
		NodeList xmlChild = xmldoc.getElementsByTagName("child");

		LinkedList<Person> pupil = new LinkedList<Person>();

		for (int i = 0; i < xmlPeople.getLength(); i++) {

			Node current = xmlPeople.item(i);
			if (current instanceof Element) {
				Element currentElement = (Element) current;
				String name = currentElement.getAttribute("name");
				String lastName = currentElement.getAttribute("lastName");
				Person personTemp = new Person(name, lastName);
				NodeList xmlChildren = current.getChildNodes();
				for (int j = 0; j < xmlChildren.getLength(); j++) {
					Node currentChild = xmlChildren.item(j);
					if (currentChild instanceof Element) {
						Element currentChildElement = (Element) currentChild;
						String nameChild = currentChildElement
								.getAttribute("name");
						String lastNameChild = currentChildElement
								.getAttribute("lastName");
						personTemp
								.addChild(new Person(nameChild, lastNameChild));
					}
					pupil.add(personTemp);
				}
			}

		}

		Iterator<Person> irr = pupil.iterator();
		while (irr.hasNext()) {
			System.out.println(irr.next().toString());
		}

	}

}
