package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 *
 */
public class JoystickDrive extends Command {
    
    private double x;
    private double y;
    private double z;
    private boolean gyroButtonForward;
    private boolean gyroButtonBackward;
    private double governer;
    private boolean isReversed;

    private double x1;
    private double y1;

    private boolean isLimited;
    // private double multiplier;

    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.m_driveTrain);

        isLimited = false;
        // multiplier = 1;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Robot.m_driveTrain.ResetGyro();   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        x = Robot.m_oi_pilot.getRawAxis(RobotMap.DriveXAxis);
        y = Robot.m_oi_pilot.getRawAxis(RobotMap.DriveYAxis);
        z = Robot.m_oi_pilot.getRawAxis(RobotMap.DriveZAxis);
        gyroButtonForward = Robot.m_oi_pilot.getRawButton(RobotMap.ResetForwardButton);
        gyroButtonBackward = Robot.m_oi_pilot.getRawButton(RobotMap.ResetBackwardButton);        
        governer = Robot.m_oi_pilot.getRawAxis(RobotMap.DriveGoverner);

        if(gyroButtonForward){
            Robot.m_driveTrain.ResetGyro();
            isReversed = false;
        }
        else if(gyroButtonBackward){
            Robot.m_driveTrain.ResetGyro();
            isReversed = true;
        }
        
        x = (Math.abs(x) > RobotMap.DeadZone ? x : 0.0);
        y = (Math.abs(y) > RobotMap.DeadZone ? y : 0.0);
        z = (Math.abs(z) > RobotMap.DeadZone ? z : 0.0);

        x1 = Robot.m_driveTrain.TransformX(x, y, isReversed);
        y1 = Robot.m_driveTrain.TransformY(x, y, isReversed);

        Robot.m_driveTrain.Drive (-x, y, z, Math.abs(governer - 1));
        gyroButtonForward = false;
        gyroButtonBackward = false;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	isFinished();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}