package org.usfirst.frc1073.robot18.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/*** If Chooser is set to Right and FMS is LLL */
public class Auto3CommandR_LL extends CommandGroup {
	/** If Chooser is set to Right and FMS is LLL */
	public Auto3CommandR_LL(){
		SmartDashboard.putString("CurrentCommand", "R_LL is running");
	}
}