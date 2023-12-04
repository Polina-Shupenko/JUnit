package lab6sitaris.parser.coursefactory;

public class German extends Course {
    public German(int id, String name, String teacher, double price) {
        super(id, name, teacher, "Немецкий язык", price);
    }


    @Override
    public void sayhello() {
        System.out.println("Я из Германии.");
    }
}