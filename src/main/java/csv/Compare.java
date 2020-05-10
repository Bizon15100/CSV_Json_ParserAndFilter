package csv;

import java.util.Comparator;

public class Compare implements Comparator<String> {
    @Override
    public int compare(String t1, String t2) {
        if(t1.equals(t2)){
            return 1;
        } else return 0;

    }
}
