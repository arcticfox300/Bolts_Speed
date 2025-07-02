package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import kotlin.math.*

@TeleOp
class TeleOp : LinearOpMode(){
    override fun runOpMode() {
        val motor_lift_right = hardwareMap.get(DcMotor::class.java, "motorR")
        val motor_lift_left = hardwareMap.get(DcMotor::class.java, "motorL")

        motor_lift_left.direction = DcMotorSimple.Direction.REVERSE

        waitForStart()

        while(opModeIsActive()) {
            val power = -gamepad1.left_stick_y.toDouble()
            motor_lift_right.power = max(1.0, power)
            motor_lift_left.power = max(1.0, power)
        }
    }
}