// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPServo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPRangefinder;
import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends SubsystemBase {
  private final XRPServo m_armServo;
  double desiredAngle;

  /** Creates a new Arm. */
  public Arm() {
    // Device number 4 maps to the physical Servo 1 port on the XRP
    m_armServo = new XRPServo(4);

  }

  @Override
  public void periodic() {
      SmartDashboard.putNumber("desiredPos", desiredAngle);
      SmartDashboard.putNumber("currentPos",getAngle());
      SmartDashboard.putBoolean("atPos", atAngle());
    // This method will be called once per scheduler run
  }

  /**
   * Set the current angle of the arm (0 - 180 degrees).
   *
   * @param angleDeg Desired arm angle in degrees
   */
  public void setAngle(double angleDeg) {
    desiredAngle = angleDeg;
    m_armServo.setAngle(angleDeg);
  }
  public double getAngle(){
   return m_armServo.getAngle();
  }
  public boolean atAngle(){
    if(m_armServo.getAngle() == desiredAngle){
      return true;
    }
    else{
      return false;
    }
  }
/**
 * 
 * @return distance
 */
}
