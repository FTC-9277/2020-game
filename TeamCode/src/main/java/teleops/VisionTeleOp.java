package teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import Vision.Sampler;
import robot.ExplosivesRobot;

@TeleOp(name = "Vision TeleOp")
public class VisionTeleOp extends OpMode {

    ExplosivesRobot robot;

    @Override
    public void init() {
//        robot = new ExplosivesRobot(this);
//        robot.setDriveTrainType(ExplosivesRobot.DriveTrainType.MECANUM);
//        robot.init();
        sampler = new Sampler(this);
    }

    int vision = -12;
    Sampler sampler;

    @Override
    public void loop() {

//        if(Math.abs(gamepad1.left_stick_y) > 0.2 || Math.abs(gamepad1.left_stick_x) > 0.2 || Math.abs(gamepad1.right_stick_x) > 0.2) {
//            robot.fleft.setPower(-(gamepad1.left_stick_y+gamepad1.left_stick_x) - gamepad1.right_stick_x);
//            robot.bleft.setPower((gamepad1.left_stick_y-gamepad1.left_stick_x) + gamepad1.right_stick_x);
//            robot.fright.setPower((gamepad1.left_stick_y+gamepad1.left_stick_x) - gamepad1.right_stick_x);
//            robot.bright.setPower(-(gamepad1.left_stick_y-gamepad1.left_stick_x) + gamepad1.right_stick_x);
//        } else {
//            robot.stop();
//        }

        telemetry.addData("Vision: ", vision);

        boolean going = false;
        if(gamepad1.a) {
//            telemetry.addData("THING: ", sampler.sample());
            vision = sampler.sample();
            if(going == false) {
                going = true;
            }
        }

//        telemetry.addData("Heading: ", robot.gyro.heading());
//        telemetry.addData("Pitch: ", robot.gyro.pitch());
//        telemetry.addData("Roll: ", robot.gyro.roll());
//        telemetry.addData("Angle: ", robot.gyro.getAngle());
    }
}
