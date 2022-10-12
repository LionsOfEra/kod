package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.INTAKE_OFF_SPEED;
import static frc.robot.Constants.IntakeConstants.INTAKE_ON_SPEED;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import static frc.robot.Constants.IntakeConstants.INTAKE_ON_FASTER_SPEED;
import static frc.robot.Constants.IntakeConstants.INTAKE_DRIVE_ID;

public class IntakeSubsystem extends SubsystemBase {
  
    //declare the motor ids
    private PWMTalonSRX intakeMotor = new PWMTalonSRX(INTAKE_DRIVE_ID);
    public IntakeSubsystem setIntakeOn;

  public IntakeSubsystem() {}

  @Override
  public void periodic() {}

    //When the command is executed this turns on and off the intake. I think
    public void setIntakeOn() {
        intakeMotor.set( INTAKE_ON_SPEED);
        } 
    public void setIntakeOff() {
        intakeMotor.set( INTAKE_OFF_SPEED);
        }
    public void setShooterOnRapid() {
        intakeMotor.set( INTAKE_ON_FASTER_SPEED);
        }
    
    public void setIntake(double speed){
        intakeMotor.set(speed);

    }

    public void intakeCommand(double rawAxis) {
    }

}