package al_lessons.a_homework;

public class Human implements Competitive {

    String name;
    int runMax;
    int jumpMax;

    Human(int runMax, int jumpMax, String name) {
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Человек пробежал");
    }

    @Override
    public void jump() {
        System.out.println("Человек перепрыгнул");
    }

    @Override
    public int getRunMax() {
        return runMax;
    }

    @Override
    public int getJumpMax() {
        return jumpMax;
    }
}
