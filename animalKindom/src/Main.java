public class Main {
    public static void main(String[] args) {

        Monkey monkey = new Monkey();

        monkey.setAge(1);
        monkey.setKingdom("Animalia");
        monkey.setMammal(true);
        monkey.setWarmBlooded(true);
        monkey.setName("Monkey");

        monkey.saySomething();
        monkey.sleep();
        monkey.eat();
        monkey.throwShit();

        StarFish starfish = new StarFish();

        starfish.setAge(5);
        starfish.setKingdom("Animalia");
        starfish.setMammal(false);
        starfish.setWarmBlooded(false);
        starfish.setName("Starfish");

        starfish.saySomething();
        starfish.sleep();
        starfish.eat();
        starfish.crawl();
    }
}