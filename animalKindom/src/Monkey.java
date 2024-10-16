import java.util.Random;

public class Monkey extends Entity {

    public void saySomething() {
        System.out.println("Oooh ahhh");
    }

    public void throwShit() {
        System.out.println("The monkey throws some crap.");
    }

    public void eat() {
        System.out.println("The monkey ate a banana. yum.");
    }

    public void sleep() {
        Random random = new Random();
        int timeSlept = random.nextInt(10) + 1;
        System.out.println("The monkey climbed in a tree, and went to sleep for " + timeSlept + " hours.");
    }
}
