package org.usfirst.frc1073.robot18.commands;

import org.usfirst.frc1073.robot18.Robot;
import org.usfirst.frc1073.robot18.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IsCubeIn extends Command {
	
	public double voltage, stopVoltage;
	
	public IsCubeIn() {
		
	}
	
	protected void initialize() {
		Robot.clawBool = false;
		stopVoltage = .8;
	}

	protected void execute() {
		voltage = RobotMap.clawSensor.getAverageVoltage();
		SmartDashboard.putNumber("volts", voltage);
	}
	
	protected boolean isFinished() {
		boolean isFinished = false;
		if (stopVoltage <= voltage) {
			Robot.clawBool = true;
			isFinished = true;
		}
		return isFinished;
	}
}
