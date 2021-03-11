package filosofiACena;

class Philosopher extends Thread {
    private int identity;
    private boolean stopRequested = false;
    private Fork left, right;
    private Table table;

    Philosopher(int id, Fork left, Fork right, Table table) {
        this.identity = id;
        this.left = left;
        this.right = right;
        this.table = table;
    }
    public void run() {
        while (!stopRequested) {
            try {
                //thinking
                sleep(50*Math.round(Math.random()));
                //hungry
                right.get();
                sleep(50*Math.round(Math.random()));
                left.get();
                //eating
                System.out.println("Philosopher " + identity + " eating...");
                sleep(50*Math.round(Math.random()));
                right.put();
                left.put();
            } catch (InterruptedException e) {

            }
        }
    }
    public void stopRequested() {
        stopRequested = true;
    }
    public int getIdentity(){
        return identity;
    }
}