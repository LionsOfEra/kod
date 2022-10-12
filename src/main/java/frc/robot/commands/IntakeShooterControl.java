// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeShooterControl extends CommandBase {
  IntakeSubsystem intakeSubsystem;
  ShooterSubsystem shooterSubsystem;
  Joystick logitechController2;
  /** Creates a new IntakeShooterControl. */
  public IntakeShooterControl(IntakeSubsystem intake, ShooterSubsystem shooter, Joystick logitech2) {
     intakeSubsystem = intake;
     shooterSubsystem = shooter;
     logitechController2 = logitech2;
    addRequirements(intakeSubsystem, shooterSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intakeSubsystem.setIntake(logitechController2.getRawAxis(1));
    shooterSubsystem.ShooterLeftMotor(logitechController2.getRawAxis(1));
    shooterSubsystem.ShooterLeftMotor(logitechController2.getRawAxis(5));
    shooterSubsystem.ShooterRightMotor(logitechController2.getRawAxis(5));
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setIntakeOff();
    shooterSubsystem.setShooterOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
