package org.firstinspires.ftc.teamcode.MotorTest;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class EkanshLinearOpModeMotor extends LinearOpMode {

    private DcMotor motor;

    @Override
    public void runOpMode() {
        motor = hardwareMap.get(DcMotor.class, "motor");

        waitForStart();

        while(opModeIsActive())
            motor.setPower(0.5f);


    }
}
