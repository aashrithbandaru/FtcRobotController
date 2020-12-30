package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Forward", group="Linear Opmode")


public class Autonomous extends Movement2 {
    private ElapsedTime runtime = new ElapsedTime();


    @Override public void runOpModeImpl() {

        waitForStart();
        runtime.reset();


        strafeRightForDistance( , );
        stop( );
        wobblerpickup(0.5, 0.5);
        stop( );
        armUp(0.7);
        stop( );
        //detect stack of rings
        goForwardForDistance( , );
        intake(0.75);
        hopper(0.75);
        outtake(1);
        stop( );
        goForwardForDistance( , );
        stop( );
        armDown(0.7);
        wobblerpickup(1, 0);
        stop ( );



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