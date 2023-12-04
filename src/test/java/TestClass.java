
import lab6sitaris.parser.Catalog;
import lab6sitaris.parser.Parser;
import lab6sitaris.parser.coursefactory.CourseFactory;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClass {

        private static Catalog actual;
        private static Catalog expected;
        private static final CourseFactory factory = new CourseFactory();

        @BeforeAll
        static void loadResources(){

            expected = Parser.parseCatalog("D:\\sitaris6\\src\\main\\resources\\courses.xml");
            actual = new Catalog();
            actual.push(factory.createCourse(1, "Курс английского языка для начинающих", "Фалес Макс", "Английский язык", 1008.0));
            actual.push(factory.createCourse(2, "Курс немецкого языка для детей", "Корбунова А.О.", "Немецкий язык", 653.0));
        }

        @Disabled
        @Test
        @Order(1)
        public void testProductsExist(){
            assertNotNull(expected.getCourses());
        }


        @Test
        @Order(2)
        public void testXmlParsingPerformance() {

        String filePath = "D:\\sitaris6\\src\\main\\resources\\courses.xml";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            long startTime = System.currentTimeMillis();


            Document document = builder.parse(new File(filePath));

            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;


            long reasonableTimeThreshold = 100;

            assertTrue(duration < reasonableTimeThreshold, "Время разбора большого XML файла превысило разумный порог");
        } catch (Exception e) {
            fail("Ошибка при разборе большого XML файла: " + e.getMessage());
        }
        }

        @Test
        @Order(3)
        public void testAvgPrice(){
            double expectedPrice = expected.average();
            double actualPrice = 0;
            for(double p : actual.getPrices()){
                actualPrice += p;
            }
            actualPrice /= actual.getPrices().size();
            assertEquals( expectedPrice, actualPrice,"Средние цены не равны ");
        }


}
