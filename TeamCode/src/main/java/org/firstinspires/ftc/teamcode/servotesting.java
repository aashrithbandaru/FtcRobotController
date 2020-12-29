package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="servotesting", group="Linear Opmode")
public class servotesting extends ServoClass {
    private ElapsedTime runtime = new ElapsedTime();

        @Override
        public void runOpModeImpl() {
            // TODO Set up frontServo in movement

            waitForStart();
            runtime.reset();


            while(opModeIsActive()) {
                while(true) {

                    if(gamepad2.right_bumper) {
                        wobblerpickup(0.5, 0.5);
                    }

                    if(gamepad2.left_bumper) {
                        wobblerpickup(1, 0);
                    }

/*                    if(gamepad1.a) {
                        arm.setPosition(0.4);
                        sleep(200);
                    }

                    if(gamepad1.b) {
                        arm.setPosition(0.8);
                        sleep(200);
                    }

                    if(gamepad1.y) {
                        arm.setPosition(0.6);
                        sleep(200);
                    }

                    if(gamepad1.x) {
                        arm.setPosition(0.25);
                        sleep(200);
                    }

                    if(gamepad1.dpad_up) {
                        clamp.setPosition(1);
                        sleep(200);
                    }

                    if(gamepad1.dpad_down) {
                        clamp.setPosition(0);
                        sleep(200);
                    }

                    if(gamepad1.dpad_left) {
                        clamp.setPosition(0.75);
                        sleep(200);
                    }

                    if(gamepad1.dpad_right) {
                        clamp.setPosition(0.25);
                        sleep(200);
                    }

*/
                    telemetry.addData("Status", "Run Time: " + runtime.toString());
                    telemetry.update();
                }
            }

        }
    }