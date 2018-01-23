
package org.usfirst.frc1073.robot18.subsystems;

import org.usfirst.frc1073.robot18.RobotMap;
import org.usfirst.frc1073.robot18.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class robotDrivetrain extends Subsystem {
	
    private final WPI_TalonSRX rightMotor1 = RobotMap.rightMotor1;
    private final WPI_TalonSRX rightMotor2 = RobotMap.rightMotor2;
    private final WPI_TalonSRX rightMotor3E = RobotMap.rightMotor3E;
    private final WPI_TalonSRX leftMotor1 = RobotMap.leftMotor1;
    private final WPI_TalonSRX leftMotor2 = RobotMap.leftMotor2;
    private final WPI_TalonSRX leftMotor3E = RobotMap.leftMotor3E;
    private final Encoder rightEnc = RobotMap.rightEnc;
    private final Encoder leftEnc = RobotMap.leftEnc;
    
    private boolean leftInverted = true;
    private boolean rightInverted = true;
    
    public DifferentialDrive difDrive;
    
	public robotDrivetrain() {
	    	leftMotor1.setInverted(leftInverted);
	    	leftMotor2.setInverted(leftInverted);
	    	leftMotor3E.setInverted(leftInverted);
	    	rightMotor1.setInverted(rightInverted);
	    	rightMotor2.setInverted(rightInverted);
	    	rightMotor3E.setInverted(rightInverted);
	    	
	    	leftMotor2.follow(leftMotor3E);
	    	leftMotor1.follow(leftMotor3E);
	    	rightMotor2.follow(rightMotor3E);
	    	rightMotor1.follow(rightMotor3E);
	    	
	    	rightMotor1.setSafetyEnabled(false);
	    	rightMotor2.setSafetyEnabled(false);
	    	rightMotor3E.setSafetyEnabled(false);
	    	leftMotor1.setSafetyEnabled(false);
	    	leftMotor2.setSafetyEnabled(false);
	    	leftMotor3E.setSafetyEnabled(false);
	    	
	    	difDrive = new DifferentialDrive(RobotMap.leftMotor3E, RobotMap.rightMotor3E);
	    	}
    
    @Override
    public void initDefaultCommand() {
    	setDefaultCommand(new ControllerDifferentialDrive());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //Used for non-PID auto routines (semi-temp).
    public void basicDrive(double left, double right) {
    	
    	rightMotor3E.set(right);
    	leftMotor3E.set(left);
    }
    
    public void arcadeDrive(double left, double right) {
        
    	//double tempLeft = cubicScale(deadzone(left,DEADZONE_VALUE),CUBIC_SCALE)-cubicScale(deadzone(right,DEADZONE_VALUE*3),CUB);
    	//double tempRight = cubicScale(deadzone(left,DEADZONE_VALUE),CUBIC_SCALE)+cubicScale(deadzone(right,DEADZONE_VALUE*3),CUB);
    	
    	double tempLeft = left;
    	double tempRight = right;
    	double difL,difR = 0;
    	
    	if(tempLeft > 1)
    	{
    		difL = tempLeft-1;
    		tempRight -= difL;
    		tempLeft = 1;
    	}
    	if(tempRight > 1)
    	{
    		difR = tempRight-1;
    		tempLeft -= difR;
    		tempRight = 1;
    	}
    	if(tempLeft < -1)
    	{
    		difL = tempLeft+1;
    		tempRight -= difL;
    		tempLeft = -1;
    	}
    	if(tempRight < -1)
    	{
    		difR = tempRight+1;
    		tempLeft -= difR;
    		tempRight = -1;
    	}
    	
//    	if(isPrecision)
//    	{
//    		//Should change when testing for max ease for driver to line up
//    		tempLeft /= 3;
//    		tempRight /= 3;
//    	}
    	
    	    	
    		
    	RobotMap.rightMotor3E.set(ControlMode.PercentOutput, tempRight);
        RobotMap.leftMotor3E.set(ControlMode.PercentOutput, tempLeft);
    }

}
