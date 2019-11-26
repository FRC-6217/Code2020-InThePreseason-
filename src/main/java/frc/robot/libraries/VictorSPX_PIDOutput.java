package frc.robot.libraries;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.PIDOutput;

/* Wrapper class for VictorSPX and PIDOutpt class;
 * It takes VictorSPX motor object and writes the
 * PIDOutput given by PIDControl;
*/

public class VictorSPX_PIDOutput implements PIDOutput {
	private VictorSPX motor;
	
	public VictorSPX_PIDOutput(VictorSPX motor) {
		this.motor = motor;
	}
	
	public void pidWrite(double output) {
		motor.set(ControlMode.PercentOutput, output); 
	}
}