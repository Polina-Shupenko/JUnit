package lab6sitaris.parser;

import lab6sitaris.parser.coursefactory.CourseFactory;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class CourseXMLHandler extends DefaultHandler {
    Catalog myCatalog = null;
    int id;
    String name;
    String teacher;
    String language;
    Double price;

    CourseFactory factory = new CourseFactory();

    String currentCharacters;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        switch (qName) {
            case "catalog": {
                myCatalog = new Catalog();
                break;
            }
            case "course": {
                id = Integer.parseInt(attributes.getValue("id"));
                break;
            }

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {

            case "course": {
                myCatalog.push(factory.createCourse(id, name, teacher, language, price));
                break;
            }
            case "name": {
                name = currentCharacters.trim();
                break;
            }
            case "teacher": {
                teacher = currentCharacters.trim();
                break;
            }
            case "language": {
                language = currentCharacters.trim();
                break;
            }
            case "price": {
                price = Double.parseDouble(currentCharacters);
                break;
            }
        }

    }

    @Override
    public void characters(char ch[], int start, int length) {
        currentCharacters = new String(ch, start, length);
    }


    public Catalog getMyCatalog() {
        return myCatalog;
    }


}
