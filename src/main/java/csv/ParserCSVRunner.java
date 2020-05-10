package csv;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;


public class ParserCSVRunner {
    @SneakyThrows
    public static void main(String[] args) throws IOException {
        SplitCSV splitCSV = new SplitCSV();
        File csvFile = new File("./employees.csv");
        CSVParser parser = CSVParser.parse(csvFile, Charset.defaultCharset(), CSVFormat.RFC4180); //parsing CSV file
        List<Data> list1 = splitCSV.parser2(parser);        //and putting it into list
        Compare comparator = new Compare();

        Map<String, Double> resultMap = splitCSV.filter(list1);
        System.out.println(resultMap.entrySet());
    }
}

