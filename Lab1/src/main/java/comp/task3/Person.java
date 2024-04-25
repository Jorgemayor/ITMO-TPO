package comp.task3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Status status;
    private List<Belonging> belongings;

    public Person(String name) {
        this.name = name;
        this.status = Status.NORMAL;
        this.belongings = new ArrayList<>();
    }

    public Person(String name, Status status) {
        this.name = name;
        this.status = status;
        this.belongings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setBelongings(List<Belonging> belongings) {
        this.belongings = belongings;
    }

    public List<Belonging> getBelongings() {
        return this.belongings;
    }

    public void takeObject(Belonging belonging) {
        this.belongings.add(belonging);
    }

    public void slap(Person person) {
        System.out.println(STR."\{this.name} slapped \{person.getName()}!");
        if(this.name.equals("Ford") && person.getName().equals("Arthur"))
            person.setStatus(Status.FROZEN);
        else
            person.setStatus(Status.ANGRY);
    }

    public void throwObject(Place place) throws Exception {
        if(this.belongings.isEmpty()) throw new Exception("There are no objects to throw!");
        Belonging belonging = this.belongings.getFirst();
        if(place.equals(Place.CANAL) && !belonging.getType().equals(TypeOfObject.FISH))
            throw new Exception("You can only throw fish to the canal!");

        this.belongings.removeFirst();
        System.out.println(STR."\{name} threw \{belonging.getType()} to \{place}");
    }

    public Belonging getMostValuableObject() throws Exception {

        if (belongings.isEmpty()) {
            throw new Exception(STR."\{name} has no objects!");
        }

        Belonging max = belongings.getFirst();

        for (Belonging obj : belongings) {
            int value = obj.getValue();
            if (value > max.getValue()) {
                max = obj;
            }
        }

        return max;
    }

    public Belonging getLeastValuableObject() throws Exception {

        if (belongings.isEmpty()) {
            throw new Exception(STR."\{name} has no objects!");
        }

        Belonging min = belongings.getFirst();

        for (Belonging obj : belongings) {
            int value = obj.getValue();
            if (value < min.getValue()) {
                min = obj;
            }
        }

        return min;
    }

    public Belonging steal(Person person) throws Exception {

        Belonging obj = person.getMostValuableObject();
        person.belongings.remove(obj);
        System.out.println(STR."\{name} stole a \{obj.getType()} from \{person.name}");
        return obj;
    }

    public Belonging gift(Person person) throws Exception {
        Belonging obj = this.getLeastValuableObject();
        this.belongings.remove(obj);
        person.getBelongings().add(obj);
        System.out.println(STR."\{name} gifted a \{obj.getType()} from \{person.name}");
        return obj;
    }
}
