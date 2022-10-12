// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
/*import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;*/
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  WPI_TalonSRX MOTOR_FRONT_LEFT = new WPI_TalonSRX(DriveConstants.WPI_TalonSRX_1_ID); // pin numaraları constantstan olacak
  public WPI_VictorSPX MOTOR_REAR_LEFT= new WPI_VictorSPX(DriveConstants.WPI_VictorSPX_1_ID);
  MotorControllerGroup MOTORS_LEFT = new MotorControllerGroup(MOTOR_FRONT_LEFT, MOTOR_REAR_LEFT);

  WPI_TalonSRX MOTOR_FRONT_RIGHT = new WPI_TalonSRX(DriveConstants.WPI_TalonSRX_2_ID); // Büyük i kullanma no türkçe karakter I
  WPI_VictorSPX MOTOR_REAR_RIGHT = new WPI_VictorSPX(DriveConstants.WPI_VictorSPX_2_ID);
  MotorControllerGroup MOTORS_RIGHT = new MotorControllerGroup(MOTOR_FRONT_RIGHT, MOTOR_REAR_RIGHT);
  DifferentialDrive DRIVE = new DifferentialDrive(MOTORS_LEFT, MOTORS_RIGHT);

  /*PWMTalonSRX MOTOR_FRONT_LEFT = new PWMTalonSRX(DriveConstants.WPI_TalonSRX_1_ID); // pin numaraları constantstan olacak
  public PWMVictorSPX MOTOR_REAR_LEFT= new PWMVictorSPX(DriveConstants.WPI_VictorSPX_1_ID);
  MotorControllerGroup MOTORS_LEFT = new MotorControllerGroup(MOTOR_FRONT_LEFT, MOTOR_REAR_LEFT);

  PWMTalonSRX MOTOR_FRONT_RIGHT = new PWMTalonSRX(DriveConstants.WPI_TalonSRX_2_ID); // Büyük i kullanma no türkçe karakter I
  PWMVictorSPX MOTOR_REAR_RIGHT = new PWMVictorSPX(DriveConstants.WPI_VictorSPX_2_ID);
  MotorControllerGroup MOTORS_RIGHT = new MotorControllerGroup(MOTOR_FRONT_RIGHT, MOTOR_REAR_RIGHT);
  DifferentialDrive DRIVE = new DifferentialDrive(MOTORS_LEFT, MOTORS_RIGHT);*/

  public DriveSubsystem() {

  MOTORS_LEFT.setInverted(false);
  MOTORS_RIGHT.setInverted(false);

  leftEncoder.setDistancePerPulse(DriveConstants.EncoderDistancePerPulse); //Encoderların bir tikteki aldığı mesafe
  rightEncoder.setDistancePerPulse(DriveConstants.EncoderDistancePerPulse);
  resetEncoders();
  }


  //resets the encoders to read a position of 0
  private void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
 }
  // The left-side drive encoder
  private final Encoder leftEncoder =
  new Encoder(
      DriveConstants.LeftEncoderPorts[0],
      DriveConstants.LeftEncoderPorts[1]);
// The right-side drive encoder
 private final Encoder rightEncoder =
   new Encoder(
      DriveConstants.RightEncoderPorts[0],
      DriveConstants.RightEncoderPorts[1]);
 public Encoder getRightEncoder() {
   return rightEncoder;
   }
 public Encoder getLeftEncoder() {
   return leftEncoder;
 }
   
   

 //Encoder'ın ilerlediği metre sayısı
   public double getEncoderMeters() {
     return (leftEncoder.get() + -rightEncoder.get()) / 2 * DriveConstants.EncoderDistancePerPulse;
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
  /*public void setSlowSpeed(){
    DRIVE.set(kSpeed * );
  }*/

  public void tankDrive(double leftSpeed, double rightSpeed)
  {
    DRIVE.tankDrive(rightSpeed, leftSpeed);
  }
  

  public void speed(double rawAxis, double rawAxis2) {
    
  }

}