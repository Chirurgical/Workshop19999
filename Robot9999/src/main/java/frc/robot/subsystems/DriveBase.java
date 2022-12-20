// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriveBase() {

  }

  CANSparkMax m_leftMotor = new CANSparkMax(0, MotorType.kBrushless);
  CANSparkMax m_rightMotor = new CANSparkMax(1, MotorType.kBrushless);
  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  public void arcadeDrive(double forwardSpeed, double rotationSpeed){
  m_drive.arcadeDrive(forwardSpeed, rotationSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
