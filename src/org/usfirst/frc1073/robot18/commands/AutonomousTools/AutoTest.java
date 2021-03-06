package org.usfirst.frc1073.robot18.commands.AutonomousTools;

import org.usfirst.frc1073.robot18.Robot;
import org.usfirst.frc1073.robot18.subsystems.robotDrivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
    	addParallel(new LiftElevatorToDistanceScale(30.0));
		addParallel(new OpenClaw());
		addSequential(new AdvancedDrive(-.8, 125, 80));
		addParallel(new Dropoff(5, "left"));
		addParallel(new LiftElevatorToDistanceScale(0));
		addParallel(new CloseClaw());
		addSequential(new AdvancedDrive(-.8, 75, 0));
    }
}
