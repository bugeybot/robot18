package org.usfirst.frc1073.robot18.commands.AutonomousTools;

import edu.wpi.first.wpilibj.command.CommandGroup;

/***
 * Cube Collection System
 * If it doesn't get a cube, you did something wrong.S
 * @author Nathaniel
 * @see VisionCubeTracker()
 */
public class CubeGetter extends CommandGroup {
	
	/**
	 * Cube Collection System:
	 * If it doesn't get a cube, you did something wrong
	 * @author Nathaniel
	 * @see IsCubeIn()
	 * @see VisionCubeTracker()
	 */
	public CubeGetter() {
		addSequential(new EncoderCheck()); //Checks encoders before running
		addParallel(new CollectorDown());
		addSequential(new OpenClaw()); //Puts collector in optimal cube collecting position
		addParallel(new IsCubeIn());
		addSequential(new VisionCubeTracker()); //Tracks cube until it is inside the collector
		addSequential(new SuckInCube(1.5, .3)); //Pulls in and clamps onto cube
		System.out.println("Auto Completed");
	}
}
