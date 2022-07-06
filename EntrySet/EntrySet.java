import java.util.*;

public class EntrySet{

    public static void main(String[] args) {
        Map<String, Integer> employers = new TreeMap<>();
        employers.put("Ivanov", 2500);
        employers.put("Petrov", 3500);
        employers.put("Vasechkin", 4500);
        employers.put("Sidorov", 3000);
        employers.put("Pushkin", 2800);
        employers.put("Tolstoi", 9500);
        employers.put("Esenin", 7000);
        System.out.println(employers);

        Set<Map.Entry<String, Integer>> entrySet = employers.entrySet();
        System.out.println(entrySet);

        List<Map.Entry<String,Integer>> list = new ArrayList<>(entrySet);
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(list);

        Map<Integer, String> newEmployers = new TreeMap<>();
        for(Map.Entry<String,Integer> value : list ){
            newEmployers.put(value.getValue(), value.getKey());
        }
        System.out.println(newEmployers);
    }
}
