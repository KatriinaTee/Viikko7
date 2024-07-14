package main;

public class Course implements PrintInfo {
    private int maxNumberOfStudents;
    private String name;
    private String id;
    
    public Course(int maxNumberOfStudents, String name, String id) {
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.name = name;
        this.id = id;
    }
    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }
    public void setMaxNumberOfStudents(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String getInformation() {
        return id +" " + name;
       
    }
    
    
}
