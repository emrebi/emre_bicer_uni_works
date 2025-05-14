public class RacingCar extends Thread {
    private String model;
    private int speed;

    public RacingCar(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public void run() {
        try {
            go();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void go() throws InterruptedException {
        int trackLength = 5000;
        int checkPointPassed = 0;
        for(int i = 0; i < trackLength; i += speed) {
            if(checkPointPassed * 1000 < i) {
                checkPointPassed++;
                System.out.println(this.model + " has passed the " + checkPointPassed + "th check point");
            }
            Thread.sleep(10);
        }
    }
}
