package al_lessons.a_homework;

public class Cat implements Competitive {

    String name;
    int runMax;
    int jumpMax;

    Cat(int runMax, int jumpMax, String name) {
        this.name = name;
        this.runMax = runMax;
        this.jumpMax = jumpMax;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Кот пробежал");
    }

    @Override
    public void jump() {
        System.out.println("Кот перепгрыгнул");
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
