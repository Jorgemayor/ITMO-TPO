package task3;

import comp.task3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    private Person raul;
    private Person karen;
    private Person ford;
    private Person arthur;

    private Belonging obj1;
    private Belonging obj2;
    private Belonging obj3;
    private Belonging obj4;
    private Belonging obj5;

    @BeforeEach
    void init() {
        raul = new Person("Raul", Status.ATTRACTED);
        karen = new Person("Karen");
        ford = new Person("Ford");
        arthur = new Person("Arthur");

        obj1 = new Belonging(TypeOfObject.FISH, 10);
        obj2 = new Belonging(TypeOfObject.PAPER, 5);
        obj3 = new Belonging(TypeOfObject.ROCK, 2);
        obj4 = new Belonging(TypeOfObject.VASE, 50);
        obj5 = new Belonging(TypeOfObject.SCISSORS, 20);

        raul.getBelongings().add(obj1);
        raul.getBelongings().add(obj3);
        raul.getBelongings().add(obj5);
        karen.getBelongings().add(obj1);
        karen.getBelongings().add(obj2);
        karen.getBelongings().add(obj3);
        ford.getBelongings().add(obj4);
    }

    @Test
    @DisplayName("Check non fish to canal")
    void checkNonFishToCanal() {
        Throwable exception = assertThrows(Exception.class, () -> ford.throwObject(Place.CANAL));
        assertEquals("You can only throw fish to the canal!", exception.getMessage());
    }

    @Test
    @DisplayName("Check no objects")
    void checkNoObjects() {
        Throwable exceptionSteal = assertThrows(Exception.class, () -> ford.steal(arthur));
        Throwable exceptionGift = assertThrows(Exception.class, () -> arthur.gift(ford));
        Throwable exceptionMost = assertThrows(Exception.class, () -> arthur.getMostValuableObject());
        Throwable exceptionLeast = assertThrows(Exception.class, () -> arthur.getLeastValuableObject());
        Throwable exceptionPlace = assertThrows(Exception.class, () -> arthur.throwObject(Place.CANAL));

        assertAll(
                () -> assertEquals("There are no objects to throw!", exceptionPlace.getMessage()),
                () -> assertEquals("Arthur has no objects!", exceptionLeast.getMessage()),
                () -> assertEquals("Arthur has no objects!", exceptionMost.getMessage()),
                () -> assertEquals("Arthur has no objects!", exceptionSteal.getMessage()),
                () -> assertEquals("Arthur has no objects!", exceptionGift.getMessage())
        );
    }

    @Test
    @DisplayName("Check status")
    void checkStatus() {
        ford.slap(arthur);
        assertAll(
                () -> assertEquals(Status.FROZEN, arthur.getStatus()),
                () -> assertEquals(Status.NORMAL, karen.getStatus()),
                () -> assertEquals(Status.ATTRACTED, raul.getStatus())
        );
        karen.slap(raul);
        assertEquals(Status.ANGRY, raul.getStatus());
    }

    @Test
    @DisplayName("Check belongings")
    void checkBelongings() {
        try {
            Belonging objRaul = arthur.steal(raul);
            Belonging objGift = raul.gift(karen);
            Belonging objFord = ford.gift(karen);

            assertAll(
                    () -> assertEquals(obj4, objFord),
                    () -> assertEquals(obj5, objRaul),
                    () -> assertEquals(obj3, objGift)
            );
        } catch (Exception e) {
            System.out.println("Non expected exception.");
        }
    }
}
