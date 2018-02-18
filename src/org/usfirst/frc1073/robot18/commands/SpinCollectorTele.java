package org.usfirst.frc1073.robot18.commands;

import org.usfirst.frc1073.robot18.Robot;
import org.usfirst.frc1073.robot18.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SpinCollectorTele extends Command {
	
	private double speed;
	
	public SpinCollectorTele() {
		requires(Robot.collector);
	}
	
	protected void initialize() {
		speed = 0;
	}
	
	protected void execute() {
		if (Robot.oi.operatorControl.getRightTrigger() > 0) {
			speed = 1;
		}
		else if (Robot.oi.operatorControl.getLeftTrigger() > 0) {
			speed = -1;
		}
		else {
			speed = 0;
		}
		SmartDashboard.putNumber("collllet", speed);
		Robot.collector.collectDrive.tankDrive(speed, -speed);
	}

	protected boolean isFinished() {
		return false;
	}

}
