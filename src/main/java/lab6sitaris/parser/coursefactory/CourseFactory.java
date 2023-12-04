package lab6sitaris.parser.coursefactory;

public class CourseFactory {

    public Course createCourse(int id, String name, String teacher, String language, double price){

        Course toReturn = null;
        switch (language){

            case "Английский язык":{
                toReturn = new English(id, name, teacher, price);
                break;
            }
            case "Французский язык":{
                toReturn = new French(id, name, teacher, price);
                break;
            }
            case "Немецкий язык":{
                toReturn = new German(id, name, teacher, price);
                break;
            }
            default:
                throw new IllegalArgumentException("Ошибка языка:" + language);
        }
        return toReturn;
    }
}
