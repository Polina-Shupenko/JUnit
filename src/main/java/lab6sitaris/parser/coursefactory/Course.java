package lab6sitaris.parser.coursefactory;

abstract public class Course {
    protected int id;
    protected String name;
    protected String teacher;
    protected String language;
    protected double price;

    public Course() {
    }

    public Course(int id, String name, String teacher, String language, double price) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.language = language;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getLanguage() {
        return language;
    }

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLanguage(String type) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Product[id = " + getId() + "]" +
                "\nname: " + getName() +
                "\nteacher: " + getTeacher() +
                "\nlanguage: " + getLanguage() +
                "\nprice: " + getPrice() + " byn\n\n";
    }

    abstract public void sayhello();
}

