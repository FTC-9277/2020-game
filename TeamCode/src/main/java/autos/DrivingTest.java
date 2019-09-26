package autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import robot.ExplosivesRobot;

@Autonomous(name = "Driving Test")
public class DrivingTest extends LinearOpMode {

    ExplosivesRobot robot = new ExplosivesRobot(this);

    @Override
    public void runOpMode() throws InterruptedException {
        robot.setDriveTrainType(ExplosivesRobot.DriveTrainType.MECANUM);
        robot.init();

        waitForStart();

        wait(1000);

        robot.drive(0.6, 500);

    }

    public void wait(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
