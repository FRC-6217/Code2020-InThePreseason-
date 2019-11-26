/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.libraries.WheelDrive;
import frc.robot.RobotMap;
import frc.robot.commands.JoystickDrive;
import frc.robot.libraries.SwerveDriveClass;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  private WheelDrive backRight;
  private WheelDrive backLeft;
  private WheelDrive frontRight;
  private WheelDrive frontLeft;
  private SwerveDriveClass swerveDrive;

  private ADXRS450_Gyro gyro;
  // private AHRS gyroX;
  // private Pixy2 pixy = Pixy2.createInstance(LinkType.I2C);
  private double x1;
  private double y1;

  private PowerDistributionPanel pdp;

  private static final double MIN_ANGLE = 0;
  private static final double MAX_ANGLE = 360;

  private static final double MIN_OFFSET = 0;
  private static final double MAX_OFFSET = 320;

  public DriveTrain() {
    // Initilize Wheels
    backRight = new WheelDrive(RobotMap.BackRightWheelPorts);
    backLeft = new WheelDrive(RobotMap.BackLeftWheelPorts);
    frontLeft = new WheelDrive(RobotMap.FrontLeftWheelPorts);
    frontRight = new WheelDrive(RobotMap.FrontRightWheelPorts);

    // Initilize Drivetrain
    swerveDrive = new SwerveDriveClass(backRight, backLeft, frontRight, frontLeft);

    // Initilize gyro
    try {
      gyro = new ADXRS450_Gyro();
    }

    catch (Exception e) {
      SmartDashboard.putString("NAVX error",
          "If you are seeing this message being enter you are screwed, Basically the Nav x board isn't plugged in. :"
              + e);
    }

    pdp = new PowerDistributionPanel();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new JoystickDrive());
  }

  // return FRC gyro angle
  public double GetAngle() {
    SmartDashboard.putNumber("Gyro", -gyro.getAngle());
    return -gyro.getAngle();
  }

  // reset FRC gyro
  public void ResetGyro() {
    gyro.reset();
  }

  public void RecalibrateGyro() {
    gyro.calibrate();
  }

  public ADXRS450_Gyro returnGyro() {
    return gyro;
  }

  public double TransformX(double x, double y, boolean isReversed) {
    if (isReversed) {
      x1 = (x * Math.cos((GetAngle() + 180) * (Math.PI / 180))) - (y * Math.sin((GetAngle() + 180) * (Math.PI / 180)));
    } else {
      x1 = (x * Math.cos(GetAngle() * (Math.PI / 180))) - (y * Math.sin(GetAngle() * (Math.PI / 180)));
    }
    return x1;
  }

  public double TransformY(double x, double y, boolean isReversed) {
    if (isReversed) {
      y1 = (x * Math.sin((GetAngle() + 180) * (Math.PI / 180))) + (y * Math.cos((GetAngle() + 180) * (Math.PI / 180)));
    } else {
      y1 = (x * Math.sin(GetAngle() * (Math.PI / 180))) + (y * Math.cos(GetAngle() * (Math.PI / 180)));
    }
    return y1;
  }

  public void Drive(double x, double y, double z, double governer) {
    swerveDrive.drive(x * governer, y * governer, z * governer);
  }
}