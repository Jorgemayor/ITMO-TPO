package comp.task3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private Status status;
    private List<Object> belongings;

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

    public void takeObject(Object object) {
        this.belongings.add(object);
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
        Object object = this.belongings.getFirst();
        if(place.equals(Place.CANAL) && !object.getType().equals(TypeOfObject.FISH))
            throw new Exception("You can only throw fish to the canal!");

        this.belongings.removeFirst();
        System.out.println(STR."\{name} threw \{object.getType()} to \{place}");
    }

    public void steal() {

    }

    public void gift() {

    }
}
