package autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import java.util.ArrayList;

import recorder.RecordMotor;
import recorder.Recorder;
import robot.ExplosivesRobot;

@Autonomous(name = "Playback Test")
public class RecordTest extends LinearOpMode {

    ExplosivesRobot robot;

    @Override
    public void runOpMode() throws InterruptedException {

        robot = new ExplosivesRobot(this);

        waitForStart();

        Recorder recorder = new Recorder();

        ArrayList<RecordMotor> motors = new ArrayList<RecordMotor>() {{
            add(new RecordMotor("bleft", robot.bleft));
            add(new RecordMotor("bright", robot.bright));
            add(new RecordMotor("fleft", robot.fleft));
            add(new RecordMotor("fright", robot.fright));
        }};

        recorder.record("first", motors);
    }
}
