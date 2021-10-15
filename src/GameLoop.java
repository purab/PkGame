public class GameLoop implements Runnable{

    private Game game;

    private boolean running;
    private final double updateRate = 1.0d/60.0d;

    private long nextStartTime;
    private int fps, ups;

    public GameLoop(Game game) {
        this.game= game;
    }


    @Override
    public void run() {
        running=true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();

        nextStartTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;

            lastUpdate = currentTime;

            if(accumulator >= updateRate) {
                while (accumulator >= updateRate) {
                    update();
                    accumulator -= updateRate;
                }
            }
            render();
            printStats();
        }

    }

    private void printStats() {
        if(System.currentTimeMillis() > nextStartTime) {
            System.out.println(String.format("FPS: %d, UPS: %d",fps,ups));
            fps=0;
            ups=0;
            nextStartTime = System.currentTimeMillis() + 1000;
        }
    }

    private void update() {
        game.update();
        ups++;
    }

    private void render() {
        game.render();
        fps++;
    }


}
