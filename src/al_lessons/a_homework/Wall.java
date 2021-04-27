package al_lessons.a_homework;

public class Wall implements Course {

    private int height;
    private final String name = "стена";


    Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean running(int runMax) {
        return true;
    }

    @Override
    public boolean jumping(int jumpMax) {
        return jumpMax >= height;
    }

    public String getName() {
        return name;
    }
}
