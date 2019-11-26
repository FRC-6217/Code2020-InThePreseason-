// import edu.wpi.first.wpilibj.AnalogAccelerometer;

// public class Accelerometer {
//     AnalogAccelerometer accel;
//     double acceleration;
//     public Accelerometer(){
//         accel = new AnalogAccelerometer(0); // create accelerometer on analog input 0
//         accel.setSensitivity(.018); // Set sensitivity to 18mV/g (ADXL193)
//         accel.setZero(2.5); // Set zero to 2.5V (actual value should be determined experimentally)
//     }

//     public void UpdateAccel() {
//         acceleration = accel.getAcceleration();
//     }
// }