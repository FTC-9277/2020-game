package robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;

public class ExplosivesRobot {

    private OpMode opMode = null;

    public DcMotor fleft, bleft, bright, fright;

    private ArrayList<DcMotor> allMotors = new ArrayList<>();

    DriveTrainType driveTrain;

    public enum DriveTrainType {
        MECANUM, TANK
    }

    public enum Direction {
        LEFT, RIGHT
    }

    public ExplosivesRobot(OpMode op) {
        opMode = op;
        driveTrain = DriveTrainType.TANK;
    }

    public void init() {
        fleft = opMode.hardwareMap.get(DcMotor.class, "fleft");
        bleft = opMode.hardwareMap.get(DcMotor.class, "bleft");
        bright = opMode.hardwareMap.get(DcMotor.class, "bright");
        fright = opMode.hardwareMap.get(DcMotor.class, "fright");

        allMotors.add(fleft);
        allMotors.add(bleft);
        allMotors.add(bright);
        allMotors.add(fright);

        fright.setDirection(DcMotorSimple.Direction.REVERSE);
        fleft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setDriveTrainType(DriveTrainType type) {
        this.driveTrain = type;
    }

    public void drive(double speed) {
        if(speed<=1&&speed>=-1) {
            fleft.setPower(speed);
            fright.setPower(speed);
            bleft.setPower(speed);
            bright.setPower(speed);
        }
    }

    public void stop() {
        for (DcMotor motor : allMotors) {
            motor.setPower(0);
        }
    }

//    private void driveTank(double speed) {
//        fleft.setPower(speed);
//        fright.setPower(speed);
//        bleft.setPower(speed);
//        bright.setPower(speed);
//    }
//
//    private void driveMechanum(double speed) {
//        //THIS DOES NOT WORK YET AND THIS IS TEMP CODE!!!
//        fleft.setPower(opMode.gamepad1.left_stick_y + opMode.gamepad1.left_stick_x + opMode.gamepad1.right_stick_x);
//        fright.setPower(opMode.gamepad1.left_stick_y - opMode.gamepad1.left_stick_x - opMode.gamepad1.right_stick_x);
//        bleft.setPower(opMode.gamepad1.left_stick_y + opMode.gamepad1.left_stick_x - opMode.gamepad1.right_stick_x);
//        bright.setPower(opMode.gamepad1.left_stick_y - opMode.gamepad1.left_stick_x + opMode.gamepad1.right_stick_x);
//    }

    public void strafe(double speed, Direction direction) {
        if (driveTrain == DriveTrainType.MECANUM) {
            if(direction == Direction.RIGHT) {
                fleft.setPower(speed);
                bleft.setPower(-speed);
                fright.setPower(-speed);
                bright.setPower(speed);
            } else {
                fleft.setPower(-speed);
                bleft.setPower(speed);
                fright.setPower(speed);
                bright.setPower(-speed);
            }
        }
    }

    public void turn(double speed, Direction direction) {
        if (direction == Direction.LEFT) {
            fleft.setPower(-speed);
            bleft.setPower(-speed);
            fright.setPower(speed);
            bright.setPower(speed);
        } else {
            fleft.setPower(speed);
            bleft.setPower(speed);
            fright.setPower(-speed);
            bright.setPower(-speed);
        }
    }


}
