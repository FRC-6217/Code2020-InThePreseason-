/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {
  //The Ports for the Controller and the Ports of the buttons and Joysticks
  public final static int DriveJoystickPort = 0;
  public final static int XboxJoystickPort = 1;
  public final static int DriveXAxis = 0;
  public final static int DriveYAxis = 1;
  public final static int DriveZAxis = 2;
  public final static int DriveGoverner = 3;
  public final static int ResetForwardButton = 6;
  public final static int ResetBackwardButton = 5;
  public final static double DeadZone = 0.2;

  //Width and Length between the SwerveDrive, used for Pathfinder and SwerveDrive calculations
  public final static int WidthOfRobot = 19;
  public final static int LengthOfRobot = 24;
  
  //Ports of the Swerve wheels. In the format {Angle Motor, Speed Motor, Absolute Encoder}
  public final static int[] BackRightWheelPorts = { 45, 43, 3 };
  public final static int[] BackLeftWheelPorts = { 47, 44, 2 };
  public final static int[] FrontLeftWheelPorts = { 41, 46, 0 };
  public final static int[] FrontRightWheelPorts = { 40, 42, 1 };
  
}
