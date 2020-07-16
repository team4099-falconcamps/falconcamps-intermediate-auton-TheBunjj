package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TurnAngleCommand extends CommandBase {
    private double angleDegrees;
    private Drivetrain drivetrain;
    private double currentAngle = 0;
    private PIDController anglePID = new PIDController(0, 0, 0);
    public TurnAngleCommand(double angleDegrees, Drivetrain drivetrain) {
        this.angleDegrees = angleDegrees;
        this.drivetrain = drivetrain;
    }

    public boolean isFinished() {
        if(currentAngle == angleDegrees){
            return true;
        }
        return false;
    }

    @Override
    public void execute(){
        currentAngle = drivetrain.getAngle();
        double turnPower = anglePID.calculate(drivetrain.getAngle(), angleDegrees);
        drivetrain.setLRPower(turnPower, turnPower * -1);
    }
}
