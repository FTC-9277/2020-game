package robot;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ExplosivesRobot {

    private OpMode opMode = null;

    public DcMotor fleft, bleft, bright, fright;

    public ExplosivesRobot(OpMode op) {
        opMode = op;

        fleft = op.hardwareMap.get(DcMotor.class, "fleft");
        bleft = op.hardwareMap.get(DcMotor.class, "bleft");
        bright = op.hardwareMap.get(DcMotor.class, "bright");
        fright = op.hardwareMap.get(DcMotor.class, "fright");
    }

}
