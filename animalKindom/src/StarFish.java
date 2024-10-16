public class StarFish extends Entity {
    public void saySomething() {
        System.out.println("Bubbles!");
    }
    public void crawl(){
        System.out.println("The starfish crawls on the sea floor.");
    }
    public void eat() {
        System.out.println("The starfish eats a clam.");
    }
    public void sleep() {
        int timeSlept = 0;
        System.out.println("Sleep is for the weak.");
    }
}
