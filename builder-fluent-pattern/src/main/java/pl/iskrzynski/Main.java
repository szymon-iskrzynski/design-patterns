package pl.iskrzynski;

public class Main {

    public static void main(String[] args) {
        Robot robot = Robot.Builder.create()
                .setHead("Head")
                .setArms("Arms")
                .setTorso("Torso")
                .build();
        System.out.println(robot.toString());
    }
}
