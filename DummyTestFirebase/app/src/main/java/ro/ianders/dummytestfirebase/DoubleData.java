package ro.ianders.dummytestfirebase;

import java.util.HashMap;

/**
 * Created by paul.iusztin on 09.12.2017.
 */

public class DoubleData {

    private String a;
    private String b;

    public DoubleData(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public DoubleData() {
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public HashMap<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("a", a);
        result.put("b", b);

        return result;
    }
}
