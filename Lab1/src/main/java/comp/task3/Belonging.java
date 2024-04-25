package comp.task3;

public class Belonging {

    private final TypeOfObject type;
    private final int value;

    public Belonging(TypeOfObject type, int value) {
        this.type = type;
        this.value = value;
    }

    public TypeOfObject getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
