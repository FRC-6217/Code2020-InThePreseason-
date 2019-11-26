/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.libraries;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Makes methods to use an Xbox Controller with easily
 * Instead of using numbers.
 * Is based on wpblib Joystick class
 */
public class XboxController {
    private Joystick joystick;
    public enum DPAD_STATE {
        UP, RIGHTUP, RIGHT, RIGHTDOWN, DOWN, LEFTDOWN, LEFT, LEFTUP, INVALID, NONE;
    }

    public XboxController(int port) {
        joystick = new Joystick(port);
    }

    public boolean getButtonA() {
        return joystick.getRawButton(1);
    }

    public boolean getButtonB() {
        return joystick.getRawButton(2);
    }

    public boolean getButtonX() {
        return joystick.getRawButton(3);
    }
    
    public boolean getButtonY() {
        return joystick.getRawButton(4);
    }

    public boolean getButtonLB() {
        return joystick.getRawButton(5);
    }

    public boolean getButtonRB() {
        return joystick.getRawButton(6);
    }

    public boolean getButtonBACK() {
        return joystick.getRawButton(7);
    }

    public boolean getButtonSTART() {
        return joystick.getRawButton(8);
    }

    public boolean getButtonL3() {
        return joystick.getRawButton(9);
    }

    public boolean getButtonR3() {
        return joystick.getRawButton(10);
    }

    public double getLeftXAxis() {
        return joystick.getRawAxis(0);
    }

    public double getLeftYAxis() {
        return joystick.getRawAxis(1);
    }

    public double getRightXAxis() {
        return joystick.getRawAxis(4);
    }

    public double getRightYAxis() {
        return joystick.getRawAxis(5);
    }

    public double getLeftTrigger() {
        return joystick.getRawAxis(2);
    }

    public double getRightTrigger() {
        return joystick.getRawAxis(3);
    }

    public DPAD_STATE getDPAD() {
        int pov = joystick.getPOV();
        if(pov == -1) {
            return DPAD_STATE.NONE;
        }
        
        int index = Math.round((7/315) * pov);
        return DPAD_STATE.values()[index];
    }
}
