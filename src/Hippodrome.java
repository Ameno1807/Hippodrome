import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i <= 100; i++){
            move();
            print();
            Thread.sleep(200);
        }

    }

    public void print(){
        for (Horse horse : horses){
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }

    }

    public void move(){
        for (Horse horse : horses){
            horse.move();
        }

    }

    public Horse getWinner(){
        Horse result = horses.get(0);
        for (Horse horse : horses){
            if (horse.getDistance() > result.getDistance())
                result = horse;
        }
        return result;

    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");

    }



    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Lucky", 3, 0));
        game.getHorses().add(new Horse("Lion", 3, 0));
        game.getHorses().add(new Horse("Zebra", 3, 0));

        game.run();
        game.printWinner();
    }
}
