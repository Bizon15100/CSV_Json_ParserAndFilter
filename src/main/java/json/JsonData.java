package json;

public class JsonData {

    private int id;
    private String name;
    private String surname;
    private String job;
    private double salary;

    public JsonData(int id, String name, String surname, String job, double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getJob() {
        return job;
    }
    public double getSalary() {
        return salary;
    }
}
