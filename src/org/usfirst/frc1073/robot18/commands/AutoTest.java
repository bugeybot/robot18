package org.usfirst.frc1073.robot18.commands;

import org.usfirst.frc1073.robot18.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoTest extends CommandGroup {

    public AutoTest() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//addParallel(new VariableCurvatureDrive (.5, .5, false));
    	
    	addParallel(new DriveWithPID(100));
    	addParallel(new TurnWithGyro(0,0,"clockwise"));
    	
    	
    	//addParallel(new TurnWithGyro(10, 180, "clockwise"));
    	//addParallel(new TurnWithGyro(60, 90, "counterclockwise"));
    	
    	
    	
    	
    	
    	
    	
    	
    }
}