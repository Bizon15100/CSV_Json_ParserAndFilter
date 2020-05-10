package json;

import csv.Data;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Json {


    public List<JsonData> split(Object obj) {
        JSONObject jo = (JSONObject) obj;
        JSONArray employees = (JSONArray) jo.get("employees");
        List<JsonData> list = new LinkedList<>();
        for (int i = 0; i < employees.size(); i++) {
            String s = employees.get(i).toString();
            String[] elements = s.replaceAll("[\",}{]", " ").split(":| {2}");  //removing unnecessary symbols and cutting into pieces
            JsonData data = new JsonData(Integer.parseInt(elements[6]),elements[4],elements[2],elements[8],Double.parseDouble(elements[10]));  //I previously checked the position of every element using the loop
            list.add(data);
        }
        return list;
    }

    public Map<String,Double> filter(List<JsonData> dataList){

        double sumSalary = 0d;
        Map<String,Double> result = new HashMap<>();
        for (JsonData jsonRecord:dataList) {
            sumSalary += jsonRecord.getSalary();
            BigDecimal bd = new BigDecimal(sumSalary).setScale(2, RoundingMode.HALF_UP);
            double formattedSum = bd.doubleValue();
            if (!result.containsKey(jsonRecord.getJob())){
                result.put(jsonRecord.getJob(),formattedSum);
            }
        }
        return result;
    }

}