package com.team4099.falconcamps.commands;

import com.team4099.falconcamps.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterIdleCommand extends CommandBase {
    private Shooter shooter;

    public ShooterIdleCommand(Shooter shooter) {
        this.shooter = shooter;
    }

    @Override
    public void initialize() {
        shooter.setSetpoint(0);
    }
}
