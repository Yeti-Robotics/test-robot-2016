
package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Joystick leftJoystick;
	Joystick rightJoystick;
	CANTalon left1, left2, left3;
	CANTalon right1, right2, right3;
	long timer;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		leftJoystick = new Joystick(1);
		rightJoystick = new Joystick(2);
		left1 = new CANTalon(62);
		left2 = new CANTalon(1);
		left3 = new CANTalon(2);
		right1 = new CANTalon(5);
		right2 = new CANTalon(6);
		right3 = new CANTalon(7);
		
		right1.setInverted(true);
		right2.setInverted(true);
		right3.setInverted(true);
		
		timer = 0;
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional comparisons to the
	 * switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		double leftY = leftJoystick.getY();
		double rightY = rightJoystick.getY();
		
		if (leftJoystick.getRawButton(4)) {
			leftY = 0.5;
			rightY = -0.5;
		} else if (leftJoystick.getRawButton(5)) {
			leftY = -0.5;
			rightY = 0.5;
		}
		
		if (leftJoystick.getRawButton(3) 
				&& timer == 0) {
			timer = System.currentTimeMillis() + 3000;
		} else if (timer != 0 
				&& timer > System.currentTimeMillis()) {
			leftY = 0.5;
			rightY = -0.5;
		} else {
			timer = 0;
		}
		
		left1.set(leftY);
		left2.set(leftY);
		left3.set(leftY);
		right1.set(rightY);
		right2.set(rightY);
		right3.set(rightY);
		
		SmartDashboard.putNumber("Left Y",
				leftJoystick.getY());
		SmartDashboard.putNumber("Right Y",
				rightJoystick.getY());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {

	}

}
