public class Main {
    public static void main(String[] args) {
        RacingCar honda = new RacingCar("Honda", 6);
        RacingCar lamborghini = new RacingCar("Lamborghini", 100);
        RacingCar mcLaren = new RacingCar("McLaren", 8);

        honda.start();
        lamborghini.start();
        mcLaren.start();
    }
}