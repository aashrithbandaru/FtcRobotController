package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 This is an abstract class that handles 4 drive train motors.
 */
abstract class Movement2 extends LinearOpMode
{
    protected DcMotor leftFront;
    protected DcMotor rightFront;
    protected DcMotor leftBack;
    protected DcMotor rightBack;
    protected DcMotor intake;
    protected DcMotor outtake;
    protected DcMotor hopper;
    protected DcMotor wobbler;
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
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        intake = hardwareMap.get(DcMotor.class, "intake");
        outtake = hardwareMap.get(DcMotor.class, "outtake");
        hopper = hardwareMap.get(DcMotor.class, "hopper");
        wobbler = hardwareMap.get(DcMotor.class, "wobbler");
        claw1 = hardwareMap.get(Servo.class, "claw1");
        claw2 = hardwareMap.get(Servo.class, "claw2");



        // Most robots need the motor on one side to be reve`rsed to drive goBackward
        // Reverse the motor that runs backwards when connected directly to the battery
        leftFront.setDirection(DcMotor.Direction.FORWARD);
        rightFront.setDirection(DcMotor.Direction.REVERSE);
        leftBack.setDirection(DcMotor.Direction.FORWARD);
        rightBack.setDirection(DcMotor.Direction.REVERSE);
        intake.setDirection(DcMotor.Direction.FORWARD);
        hopper.setDirection(DcMotor.Direction.FORWARD);
        outtake.setDirection(DcMotor.Direction.FORWARD);
        wobbler.setDirection(DcMotor.Direction.FORWARD);

        updateTelemetryMessage("Initialized Motors");
/*
        arm = hardwareMap.get(DcMotor.class, "Arm");
        arm.setDirection(DcMotor.Direction.FORWARD);


        rightConstruction = hardwareMap.servo.get("rightConstruction");

 */
    }

    public void stop(final String message) {
        leftFront.setPower(0.0);
        rightFront.setPower(0.0);
        rightBack.setPower(0.0);
        leftBack.setPower(0.0);

        updateTelemetryMessage(message);
    }

        public void stopWithSleep(final String message, final long duration) {
            stop(message);
            sleep(duration);
    }

    public void stopWithSleep(final long duration) {
        stop("Stopping");
        sleep(duration);
    }

    public void goForward(final double power, final int duration) {
        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        updateTelemetryMessage("Going Forward");
    }

    public void goForwardForDistance(final double power, final int distance){
        //Reset encoders
        leftFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set target position
        leftFront.setTargetPosition(distance);
        rightFront.setTargetPosition(distance);
        leftBack.setTargetPosition(distance);
        rightBack.setTargetPosition(distance);

        //Set to RUN_TO_POSITION mode
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);


        while(leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy()){
            //Wait until target position is reached
        }

        //Stop and change modes back to normal
        stop();
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }

    // Backward is same as forward with reverse power
    public void goBackward(final double power, final int duration) {
        goForward(-power, duration);
    }

    public void goBackwardForDistance(final double power, final int distance){
        //Reset encoders
        leftFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set target position
        leftFront.setTargetPosition(-distance);
        rightFront.setTargetPosition(-distance);
        leftBack.setTargetPosition(-distance);
        rightBack.setTargetPosition(-distance);

        //Set to RUN_TO_POSITION mode
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while(leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy()){
            //Wait until target position is reached
        }

        //Stop and change modes back to normal
        stop();
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }

    public void strafeRight(final double power, final int duration) {
        //TODO - clarify how these motor powers are distributed for strafeRight movement
        leftFront.setPower(-power);
        rightBack.setPower(-power);
        leftBack.setPower(power);
        rightFront.setPower(power);
        sleep(duration);

        updateTelemetryMessage("Strafing Left");
    }

    public void strafeRightForDistance(final double power, final int distance){
        //Reset encoders
        leftFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set target position
        leftFront.setTargetPosition(-distance);
        rightFront.setTargetPosition(distance);
        leftBack.setTargetPosition(distance);
        rightBack.setTargetPosition(-distance);

        //Set to RUN_TO_POSITION mode
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while(leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy()){
            //Wait until target position is reached
        }

        //Stop and change modes back to normal
        stop();
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }

    public void strafeLeft(final double power, final int duration) {
        leftFront.setPower(power);
        rightFront.setPower(-power);
        rightBack.setPower(power);
        leftBack.setPower(-power);
        sleep(duration);

        updateTelemetryMessage("Strafing Right");
    }

    public void strafeLeftForDistance(final double power, final int distance){
        //Reset encoders
        leftFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set target position
        leftFront.setTargetPosition(distance);
        rightFront.setTargetPosition(-distance);
        leftBack.setTargetPosition(-distance);
        rightBack.setTargetPosition(distance);

        //Set to RUN_TO_POSITION mode
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while(leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy()){
            //Wait until target position is reached
        }

        //Stop and change modes back to normal
        stop();
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }

    protected void updateTelemetryMessage(String message) {
        updateTelemetryMessage("Status", message);
    }

    protected void updateTelemetryMessage(String caption, String message) {
        telemetry.addData("Status", message);
        telemetry.update();
    }

    protected void turnRight(final double leftwheelsforwardpower, final double rightwheelsbackwardpower,  final int duration) {
        leftFront.setPower(leftwheelsforwardpower);
        rightFront.setPower(-rightwheelsbackwardpower);
        rightBack.setPower(-rightwheelsbackwardpower);
        leftBack.setPower(leftwheelsforwardpower);
        sleep(duration);

        updateTelemetryMessage("Turning Right");
    }

    public void turnRightForDistance(final double power, final int distance){
        //Reset encoders
        leftFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set target position
        leftFront.setTargetPosition(distance);
        rightFront.setTargetPosition(-distance);
        leftBack.setTargetPosition(distance);
        rightBack.setTargetPosition(-distance);

        //Set to RUN_TO_POSITION mode
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while(leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy()){
            //Wait until target position is reached
        }

        //Stop and change modes back to normal
        stop();
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }

    protected void turnLeft(final double leftwheelsbackwardpower, final double rightwheelsforwardpower, final int duration) {
        leftFront.setPower(-leftwheelsbackwardpower);
        rightFront.setPower(rightwheelsforwardpower);
        rightBack.setPower(rightwheelsforwardpower);
        leftBack.setPower(-leftwheelsbackwardpower);
        sleep(duration);

        updateTelemetryMessage("Turning Left");
    }

    public void turnLeftForDistance(final double power, final int distance){
        //Reset encoders
        leftFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RESET_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RESET_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RESET_ENCODERS);

        //Set target position
        leftFront.setTargetPosition(-distance);
        rightFront.setTargetPosition(distance);
        leftBack.setTargetPosition(-distance);
        rightBack.setTargetPosition(distance);

        //Set to RUN_TO_POSITION mode
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Set drive power
        leftFront.setPower(power);
        rightFront.setPower(power);
        leftBack.setPower(power);
        rightBack.setPower(power);

        while(leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy()){
            //Wait until target position is reached
        }

        //Stop and change modes back to normal
        stop();
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODERS);

    }

    public void intake(final double intakepower){
        intake.setPower(intakepower);
    }

    public void hopper(final double hopperpower, final int duration){
        hopper.setPower(hopperpower);
        sleep(duration);
    }

/*    public void claw1(final double claw1position, final int duration){
        claw1.setPosition(claw1position);
        sleep(duration);
    }

    public void claw2(final double claw2position, final int duration){
        claw2.setPosition(claw2position);
        sleep(duration);
    }*/

    public void wobblerpickup(final double claw1position, final double claw2position, final int duration) {
        claw1.setPosition(claw1position);
        claw2.setPosition(claw2position);
        sleep(duration);
    }

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