package al_lessons.a_homework;

public class Main {

    public static void main(String[] args) {

        Competitive[] members = {new Cat(200, 3, "Барсик"),
                new Human(1000, 1, "Иван"),
                new Robot(50, 0, "VX-1000")};

        Course[] courses = {new RunningTrack(50),
                new Wall(1),
                new RunningTrack(150),
                new Wall(2),
                new RunningTrack(1000)};

        for (int i = 0; i < members.length; i++) {
            for (int j = 0; j < courses.length; j++) {
                if (courses[j].running(members[i].getRunMax()) & courses[j].jumping(members[i].getJumpMax())) {
                    System.out.println(members[i].getName() + " прошёл препятствие: " + courses[j].getName());
                } else {
                    System.out.println(members[i].getName() + " не прошёл препятствие: " + courses[j].getName() + " и сошёл с полосы");
                    break;
                }
            }
        }

    }
}
