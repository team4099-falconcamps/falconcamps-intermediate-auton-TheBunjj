package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {
    private double distanceMeters;
    private Drivetrain drivetrain;
    private PIDController leftPID = new PIDController(0, 0, 0);
    private PIDController rightPID = new PIDController(0, 0, 0);
    private double currentLeft = 0;
    private double currentRight = 0;

    public DriveDistanceCommand(double distanceMeters, Drivetrain drivetrain) {
        this.distanceMeters = distanceMeters;
        this.drivetrain = drivetrain;
    }

    public boolean isFinished() {
        if(currentLeft >= distanceMeters && currentRight >= distanceMeters){
            return true;
        }
        return false;
    }

    @Override
    public void execute(){
        currentLeft = leftPID.calculate(drivetrain.getLeftDistance());
        currentRight = rightPID.calculate(drivetrain.getRightDistance());
    }
}
