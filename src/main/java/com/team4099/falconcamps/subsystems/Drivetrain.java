package com.team4099.falconcamps.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private TalonFX left = new TalonFX(2);
    private TalonFX leftFollower = new TalonFX(3);
    private TalonFX right = new TalonFX(12);
    private TalonFX rightFollower = new TalonFX(13);
    private AHRS gyro = new AHRS(SPI.Port.kMXP);

    public Drivetrain() {
        leftFollower.follow(left);
        rightFollower.follow(right);

        left.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
        right.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    }

    public void setLRPower(double leftPower, double rightPower) {
        left.set(ControlMode.PercentOutput, leftPower);
        right.set(ControlMode.PercentOutput, rightPower);
    }

    public double encoderTicksToMeters(int nativeUnits) {
        return (nativeUnits / (2048 / 0.08665966387)) * 6 * Math.PI;
    }
}
