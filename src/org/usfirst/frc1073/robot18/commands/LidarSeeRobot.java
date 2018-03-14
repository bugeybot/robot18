package org.usfirst.frc1073.robot18.commands;
import edu.wpi.first.wpilibj.command.Command;


import org.usfirst.frc1073.robot18.Robot;
import org.usfirst.frc1073.robot18.RobotMap;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LidarSeeRobot extends Command {


	NetworkTable lidarSendTable;
	double lidarDegrees;
	double ultimateMeasurement;
	double robotSpeed;
	double degrees;
	double left;
	double right;
	double Inches;
	boolean SeeObject = false;

	//Variable for button used in isFinished
	boolean isPressed = false;

	public LidarSeeRobot() {

		requires(Robot.drivetrain);

		//Sets the correct Network Table to pull from the Pixy
		lidarSendTable = NetworkTable.getTable("LidarSendTable");
	}

	protected void initialize() {
		//SmartDashboard.putString("lidar info", "init");
		//SmartDashboard.putString("hello_world", "x");

	}

	protected void execute() {
		//SmartDashboard.putString("lidar info", "execute");
		//These are the variables that get manipulated in the code

		//double mmToIn = 1.0;
		//SmartDashboard.putNumber("ultimateMeasurement", ultimateMeasurement);

		//These are the variables for speed - start slow

		//These are what the Pixy send us
		robotSpeed = lidarSendTable.getNumber("robotSpeed", 99);
		SeeObject = lidarSendTable.getBoolean("Stop", false);
		degrees = lidarSendTable.getNumber("degrees",99);
		SmartDashboard.putNumber("Ultimate Lidar Measurement", ultimateMeasurement);
	
		if(SeeObject == false){
			Robot.drivetrain.difDrive.arcadeDrive(-0.25, 0);
			SmartDashboard.putBoolean("SeeRobot", false);
		}
		
		if(SeeObject == true){
			Robot.drivetrain.difDrive.arcadeDrive(0, 0);
			SmartDashboard.putBoolean("SeeRobot", true);
		}



		//This code modifies the speed based on how close you are to the peg
		SmartDashboard.putNumber("Lidar Distance" , ultimateMeasurement);
		SmartDashboard.putNumber("Lidar Degrees" , degrees);
		SmartDashboard.putNumber("Lidar To Inches", ultimateMeasurement/mmToIn);
		SmartDashboard.putNumber("Robot Speed", robotSpeed);
		



	}

	protected boolean isFinished() {
		boolean is_finished = false;
		return is_finished;

		//SmartDashboard.putString("lidar info", "isFinished");

		//Checks the cancel button for its state
		//isPressed = Robot.oi.cancelAny.get();
		//if (true){
		//SmartDashboard.putString("hello_world", "isFinished");
		//return false;
	}	
	//else 
	//	return true;
	// }

	protected void end() {
		//Stops motors and sets bling
		Robot.drivetrain.difDrive.arcadeDrive(0, 0);
		//Robot.bling.sendRemoveGear();
	}

	protected void interrupted() {
		//Stops motors and sets bling
		Robot.drivetrain.difDrive.arcadeDrive(0, 0);
		SmartDashboard.putString("lidar info", "Interrupted");
		//Robot.bling.sendRemoveGear();
	}
}
