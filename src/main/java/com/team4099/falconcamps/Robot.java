package com.team4099.falconcamps;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {
    private final RobotContainer robotContainer = new RobotContainer();
    private Command autonomousCommand;

    @Override public void robotInit() {}

    @Override public void autonomousInit() {
        autonomousCommand = robotContainer.getAutonomousCommand();
        if (autonomousCommand != null) {
            autonomousCommand.schedule();
        }
    }

    @Override public void teleopInit() {
        if (autonomousCommand != null) {
            autonomousCommand.cancel();
        }
    }

    @Override public void disabledInit() {}

    @Override public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override public void autonomousPeriodic() {}

    @Override public void disabledPeriodic() {}
}
