package csv;

public class Data {
    private String id;
    private String name;
    private String surname;
    private String job;
    private double salary;



    public Data(String id, String name, String surname, String job, double salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.salary = salary;
    }

    public String getId() {
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
