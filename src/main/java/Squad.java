import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String name;
    private int size;
    private String cause;
    private int id;
    private static ArrayList<Squad> instances = new ArrayList<Squad>();
    private List<Hero> heroes = new ArrayList<Hero>();

    public Squad(String name, int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getCause() {
        return cause;
    }

    public int getId() {
        return id;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
    public void addHero(Hero hero) {
        if (heroes.size()<this.getSize()) {
                heroes.add(hero);
        }
    }

    public static ArrayList<Squad> getSquads() {
        return instances;
    }
    public static void clearSquads() {
        instances.clear();
    }
    public void removeHeroes() {
        heroes.clear();
    }
    public void removeHero(Hero hero) {
        heroes.remove(hero);
    }
    public static Squad find(int n) {
        return instances.get(n-1);
    }
}