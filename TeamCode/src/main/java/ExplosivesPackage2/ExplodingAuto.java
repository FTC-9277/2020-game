package ExplosivesPackage2;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public abstract class ExplodingAuto extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        startAuto();
    }

    public abstract void startAuto();

}
