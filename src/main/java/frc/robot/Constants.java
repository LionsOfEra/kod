// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class DriveConstants { 
    public static final int WPI_TalonSRX_1_ID = 1;
    public static final int WPI_VictorSPX_1_ID = 4;
    public static final int WPI_TalonSRX_2_ID = 2;
    public static final int WPI_VictorSPX_2_ID = 5;
    public static final double kSpeed = 0.5;
    public static final int[] LeftEncoderPorts = new int[] {0, 1};
    public static final int[] RightEncoderPorts = new int[] {2, 3};

    public static final int EncoderCPR = 360; //it says 360 CPR on Deküp's website??
    public static final double WheelDiameterMeters = 0.15; //wheel diameter
    public static final double EncoderDistancePerPulse = //encoder'ın bir tikteki ilerliyişi
        // Assumes the encoders are directly mounted on the wheel shafts
        (WheelDiameterMeters * Math.PI) / (double) EncoderCPR;
  
  
    }
 
    public final static class ShooterConstants {
    public static final int SHOOTER_DRIVE_ID_1 = 6;
    public static final int SHOOTER_DRIVE_ID_2 = 7;
    public static final double SHOOTER_ON_SPEED = 1 ;
    public static final double SHOOTER_OFF_SPEED = 0 ;
    public static final double SHOOTER_ON_FASTER_SPEED = -0.75;
    public static final double SHOOTER_CONTROL_1 = 0;
    public static final double SHOOTER_CONTROL_2 = 0;
}
    public static final class IntakeConstants{
      public static final double INTAKE_ON_FASTER_SPEED = -0.75;
      public static final double INTAKE_ON_SPEED = 1;
      public static final double INTAKE_OFF_SPEED = 0;
      public static final int INTAKE_DRIVE_ID = 3;
}
    public static Object kSpeed;
    




}