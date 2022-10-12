package frc.robot.subsystems;




import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ShooterConstants.SHOOTER_OFF_SPEED;
import static frc.robot.Constants.ShooterConstants.SHOOTER_ON_SPEED;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import static frc.robot.Constants.ShooterConstants.SHOOTER_ON_FASTER_SPEED;
import static frc.robot.Constants.ShooterConstants.SHOOTER_DRIVE_ID_1;
import static frc.robot.Constants.ShooterConstants.SHOOTER_DRIVE_ID_2;

public class ShooterSubsystem extends SubsystemBase {
  


    public final ShooterSubsystem setShooterOn = null;
    private PWMVictorSPX SHOOTER_MOTOR_1 = new PWMVictorSPX(SHOOTER_DRIVE_ID_1);
    private PWMVictorSPX SHOOTER_MOTOR_2 = new PWMVictorSPX(SHOOTER_DRIVE_ID_2);
    


  public ShooterSubsystem() {}
    
    public void setShooterOn() {
      SHOOTER_MOTOR_1.set( SHOOTER_ON_SPEED);
      SHOOTER_MOTOR_2.set( SHOOTER_ON_SPEED);
      }
        
    public void setShooterOff() {
      SHOOTER_MOTOR_1.set( SHOOTER_OFF_SPEED);
      SHOOTER_MOTOR_2.set( SHOOTER_OFF_SPEED);
      }

    public void setShooterOnRapid() {
      SHOOTER_MOTOR_1.set( SHOOTER_ON_FASTER_SPEED);
      SHOOTER_MOTOR_2.set( SHOOTER_ON_FASTER_SPEED);
      }
    public void ShooterLeftMotor(double rightSpeed){
      SHOOTER_MOTOR_1.set(rightSpeed);
    }

    public void ShooterRightMotor(double leftSpeed){
      SHOOTER_MOTOR_2.set(leftSpeed);
     
    }
    public static void ShooterCommand(double rawAxis) {
    }

    public static void speed(double rawAxis) {
    }

    public static void speed(double rawAxis, double rawAxis2) {
    }

    public void setShooter(double rawAxis, double rawAxis2) {
    }
  
    
    

}