package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Forward", group="Linear Opmode")


public class Autonomous extends Movement2 {
    private ElapsedTime runtime = new ElapsedTime();


    @Override public void runOpModeImpl() {

        waitForStart();
        runtime.reset();
/*
        sleep(50);

        goForward(1,  20);
        //sense
        goForward(1, 20);
*/

        telemetry.addData("Status", "Stop Program");
        telemetry.update();



    }
}