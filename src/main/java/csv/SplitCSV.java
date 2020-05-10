package csv;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class SplitCSV {
    @SneakyThrows
    public List<Data> parser2(CSVParser parser) throws IOException {
        List<Data> list = new LinkedList<>();
        for (CSVRecord csvRecord : parser) {
            List<CSVRecord> records = parser.getRecords();
            for (CSVRecord s : records) {

                String[] splitCSV = s.toString().split(";");

                String[] id = splitCSV[0].split(" {4}");
                String[] salary = splitCSV[4].split("\"");
                double money = Double.parseDouble(salary[1]);
                Data data = new Data(id[1], splitCSV[1], splitCSV[2], splitCSV[3], money); //putting deserialized elements into data
                list.add(data);
            }
        }
        return list;
    }

    public Map<String,Double> filter(List<Data> dataList){

        double sumSalary = 0d;
        Map<String,Double> result = new HashMap<>();
        for (Data csvRecord:dataList) {
            sumSalary += csvRecord.getSalary();
            BigDecimal bd = new BigDecimal(sumSalary).setScale(2, RoundingMode.HALF_UP);
            double formattedSum = bd.doubleValue();
            if (!result.containsKey(csvRecord.getJob())){
                result.put(csvRecord.getJob(),formattedSum);
            }
        }
        return result;
    }

}
