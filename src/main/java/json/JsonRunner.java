package json;

import lombok.SneakyThrows;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class JsonRunner {

    @SneakyThrows
    public static void main(String[] args) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("./employees.json"));
        Json json = new Json();
        List<JsonData> listOfEmployees = json.split(obj);
        Map<String, Double> jsonResultMap = json.filter(listOfEmployees);
        for (JsonData record:listOfEmployees) {
            System.out.println( record.getId() +" " +record.getName() +" " + record.getSurname()+" " +record.getJob()+" " + record.getSalary());
        }
        System.out.println();
        System.out.println(jsonResultMap.entrySet());

    }
}
