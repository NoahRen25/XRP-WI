// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class DriveSensor extends Command {
    Arm arm;
    Drivetrain drive;
    double dist;
    final double FINISHED_COUNT = 20;
    boolean done;
    double count;
  
  /**
   * Creates a new ArmSeq. This command will drive your your robot for a desired distance at
   * a desired speed.
   *
   * @param speed The speed at which the robot will drive
   * @param inches The number of inches the robot will drive
   * @param drive The drivetrain subsystem on which this command will run
   */
    public DriveSensor(Arm arm, Drivetrain drive, double dist){
    this.arm = arm;
    this.drive = drive;
    this.dist = dist;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    done = false;
    count = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(dist > drive.getDistance()){
        arm.setAngle(80.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.setAngle(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
