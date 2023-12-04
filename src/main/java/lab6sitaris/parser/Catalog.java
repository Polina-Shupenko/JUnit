package lab6sitaris.parser;


import lab6sitaris.parser.coursefactory.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Catalog {

    public static void main(String[] args) {
        Catalog c = new Catalog();
        c = Parser.parseCatalog("D:\\sitaris6\\src\\main\\resources\\error.xml");


        Map<String, Integer> map = c.getCourses().stream()
                .collect(Collectors.toMap(Course::getLanguage, value -> 1, Integer::sum));

        System.out.println(map);
    }
    private ArrayList<Course> courses;

    public Catalog(){
        courses = new ArrayList<>();
    }

    public Map<String, Integer> getInfoForChart(){
        return  courses.stream().collect(
                Collectors.toMap(Course::getLanguage, value -> 1, Integer::sum));

    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public List<String> getNames(){
        return courses.stream().map(it-> '"'+it.getName()+'"').toList();
    }

    public Double average(){
        return courses.stream().map(Course::getPrice).reduce(Double::sum).map(it->it/courses.size())
                .orElse(-1.0);
    }

    public List<Double> getPrices(){
        return courses.stream().map(Course::getPrice).toList();
    }

    public void setCourses(ArrayList<Course> courses){
        this.courses = courses;
    }

    public  void push(Course p){
        courses.add(p);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Course p: courses){
            sb.append(p.toString());
        }
        return sb.toString();
    }

    public void sayHello(){
        for(Course p: courses){
            p.sayhello();
        }
    }
}
