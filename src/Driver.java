import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        HashMap<String, Integer> items = new HashMap<>();
        items.put("gold", 5);
        List<Monster> monster = new ArrayList<>();
        monster.add(new Imp(15, 20, items));
        monster.add(new Kobold(1, 5, items));

        for (Monster m : monster) {
            System.out.println(m);
        }
    }
}