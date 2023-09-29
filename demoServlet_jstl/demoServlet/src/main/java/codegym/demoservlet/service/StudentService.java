package codegym.demoservlet.service;

import codegym.demoservlet.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    private static Map<Integer, Student> studentMap;
    static {
        studentMap = new HashMap<>();
        studentMap.put(1, new Student(1, "Nam", 20, "Da Nang"));
        studentMap.put(2, new Student(2, "Hoang", 21, "Da Nang"));
        studentMap.put(3, new Student(3, "Lan", 22, "Quang Nam"));
        studentMap.put(4, new Student(4, "Hai", 19, "Quang Nam"));
        studentMap.put(5, new Student(5, "Manh", 20, "<h2>Da Nang</h2>"));
    }

    public List<Student> getList() {
        return new ArrayList<>(studentMap.values());
    }
}
