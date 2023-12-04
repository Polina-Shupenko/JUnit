package lab6sitaris.parser.coursefactory;

public class French extends Course {
    public French(int id, String name, String teacher, double price) {
        super(id, name, teacher, "Французский язык", price);
    }

    @Override
    public void sayhello() {
        System.out.println("Я из Франции.");
    }
}
