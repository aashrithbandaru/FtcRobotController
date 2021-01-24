package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 This is an abstract class that handles 4 drive train motors.
 */
abstract class ServoClass extends LinearOpMode
{
    protected Servo claw1;
    protected Servo claw2;

    public void runOpMode() {
        setupDriveMotors();
        runOpModeImpl();
    }

    public abstract void runOpModeImpl();

    protected void setupDriveMotors() {
        // Initialize the motor references for all the wheels
        // Initialize the hardware variables. Note that the strings used here as parameters

        updateTelemetryMessage("Initializing Motors");


        //Servos
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");


        // Most robots need the motor on one side to be reve`rsed to drive goBackward
        // Reverse the motor that runs backwards when connected directly to the battery

        /*    */

        updateTelemetryMessage("Initialized Motors");
/*
        arm = hardwareMap.get(DcMotor.class, "Arm");
arm.setDirection(DcMotor.Direction.FORWARD);qa


        rightConstruction = hardwareMap.servo.get("rightConstruction");

 */
    }

    protected void updateTelemetryMessage(String message) {
        updateTelemetryMessage("Status", message);
    }

    protected void updateTelemetryMessage(String caption, String message) {
        telemetry.addData("Status", message);
        telemetry.update();
    }

    public void claw1move(final double claw1position) {
        claw1.setPosition(claw1position);
    }

    public void claw2move(final double claw2position) {
        claw1.setPosition(claw2position);
    }
<<<<<<< HEAD

 /*   public void wobblerpickup(final double claw1position, final double claw2position, final int duration) {
        claw1.setPosition(claw1position);
        claw2.setPosition(claw2position);
        sleep(duration);
=======
*/
    public void wobblerpickup(final double claw1position, final double claw2position) {
        claw1.setPosition(claw1position);
        claw2.setPostion(claw2position);

    }
*/
/*    public void armdown() {
        arm.setPosition(1);
        sleep(200);
    }

    public void armup() {
        arm.setPosition(0);
        sleep(200);
    }

    public void clampdown() {
        clamp.setPosition(1);
        sleep(200);
    }

    public void clampup() {
        clamp.setPosition(0);
        sleep(200);
    }
*/
/*
    public void armUp(final double armpower, final int duration) {
        arm.setPower(armpower);
        sleep(duration);

        updateTelemetryMessage("Arm going up");
    }

    public void armDown(final double armpower, final int duration) {
        armUp(-armpower, duration);
    }

    public void backServosDown() {
        rightConstruction.setPosition(0.43);
        leftConstruction.setPosition(0.35);

        updateTelemetryMessage("Foundation Servos Down");
    }

    public void backServosUp() {
        rightConstruction.setPosition(1);
        leftConstruction.setPosition(1);

        updateTelemetryMessage("Foundation Servos Up");
    }
*/
}