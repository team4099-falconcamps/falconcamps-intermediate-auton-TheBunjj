package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Drivetrain;

public class TurnAngleCommand {
    private double angleDegrees;
    private Drivetrain drivetrain;

    public TurnAngleCommand(double angleDegrees, Drivetrain drivetrain) {
        this.angleDegrees = angleDegrees;
        this.drivetrain = drivetrain;
    }
}
