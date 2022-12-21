// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.SparkMaxAlternateEncoder;
import com.revrobotics.SparkMaxAlternateEncoder.Type;

public class DriveBase extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public DriveBase() {

  }
  private final int diameter = 100;

  CANSparkMax m_leftMotor = new CANSparkMax(1, MotorType.kBrushless);
  CANSparkMax m_rightMotor = new CANSparkMax(2, MotorType.kBrushless);
  DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  CANSparkMaxAlternateEncoder m_leftEncoder = m_leftMotor.getAlternateEncoder(Type.kQuadrature,20);
  CANSparkMaxAlternateEncoder m_rightEncoder = m_leftMotor.getAlternateEncoder(Type.kQuadrature,20);

  public void arcadeDrive(double forwardOrBackwardSpeed, double turnSpeed){
    m_drive.arcadeDrive(forwardOrBackwardSpeed, turnSpeed);
  }

  public void resetEncoders(double xSpeed, double xRotation){
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
  }

  public double getLeftDistance(){
    return (m_leftEncoder.getPosition() * distance * Math.PI);
  }

  public double getRightDistance(){
    return(m_rightEncoder.getPosition() * distance * Math.PI);
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
