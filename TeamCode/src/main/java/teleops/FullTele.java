package teleops;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import robot.ExplosivesRobot;

@TeleOp(name = "FullTele")
public class FullTele extends OpMode {

    ExplosivesRobot robot;

    @Override
    public void init() {
        robot = new ExplosivesRobot(this);
        robot.setDriveTrainType(ExplosivesRobot.DriveTrainType.MECANUM);
        robot.init();
    }

    @Override
    public void loop() {
//        if(Math.abs(gamepad1.left_stick_y) > 0.2 || Math.abs(gamepad1.right_stick_x) > 0.2) {
//            robot.fleft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
//            robot.fright.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
//            robot.bleft.setPower(gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
//            robot.bright.setPower(gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
//        } else {
//            robot.stop();
//        }

        if(Math.abs(gamepad1.left_stick_y) > 0.2 || Math.abs(gamepad1.left_stick_x) > 0.2 || Math.abs(gamepad1.right_stick_x) > 0.2) {
            robot.fleft.setPower(-(gamepad1.left_stick_y-gamepad1.left_stick_x) - gamepad1.right_stick_x);
            robot.bleft.setPower((gamepad1.left_stick_y+gamepad1.left_stick_x) + gamepad1.right_stick_x);
            robot.fright.setPower((gamepad1.left_stick_y+gamepad1.left_stick_x) - gamepad1.right_stick_x);
            robot.bright.setPower(-(gamepad1.left_stick_y-gamepad1.left_stick_x) + gamepad1.right_stick_x);
        } else {
            robot.stop();
        }

        if(gamepad1.left_bumper) {
            robot.left.setPower(1);
            robot.right.setPower(1);
        } else if(gamepad1.right_bumper) {
            robot.left.setPower(-1);
            robot.right.setPower(-1);
        } else {
            robot.left.setPower(0.0);
            robot.right.setPower(0.0);
        }
    }
}
