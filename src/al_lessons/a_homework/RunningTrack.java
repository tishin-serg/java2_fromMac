package al_lessons.a_homework;

public class RunningTrack implements Course {

    private final String name = "беговая дорожка";
    private int distance;

    RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean jumping(int jumpMax) {
        return true;
    }

    @Override
    public boolean running(int runMax) {
        return distance <= runMax;
    }

    public String getName() {
        return name;
    }

}
