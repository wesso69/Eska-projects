
import java.util.HashMap;
import java.util.Map;

public class DataStore {

    private Map<String, Person> Personmap = new HashMap<>();

    private static  DataStore instance = new DataStore();

    public static DataStore getinstance() {
        return instance;
    }

    private DataStore() {
        Personmap.put("waseem", new Person("waseem", "Dota2 gamer", 2000));
        Personmap.put("eid", new Person("eid", "Lol gamer", 2000));
        Personmap.put("sameer", new Person("sameer", "Fortinite gamer", 2004));
    }

    public Person getperson(String name) {
        return Personmap.get(name);
    }

    public void putperson(Person person) {
        Personmap.put(person.getName(), person);
    }

}
