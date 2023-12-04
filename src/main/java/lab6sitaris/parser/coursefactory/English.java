package lab6sitaris.parser.coursefactory;

public class English extends Course {
    public English(int id, String name, String teacher, double price) {
        super(id, name, teacher, "Английский язык", price);
    }




    @Override
    public String toString() {
        return "Course[id = " + getId() + "]" +
                "\nname: " + getName() +
                "\nteacher: " + getTeacher() +
                "\nlanguage: " + getLanguage() +
                "\nprice: " + getPrice() + " byn\n\n";
    }

    @Override
    public void sayhello() {
        System.out.println("Я из Англии.");
    }

}
