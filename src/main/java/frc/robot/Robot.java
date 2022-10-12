// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cscore.VideoSink;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.TankDriveCommand;
import frc.robot.subsystems.IntakeSubsystem;


/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot { 
  NetworkTableEntry xEntry;
  NetworkTableEntry yEntry;


  


private Command m_autonomousCommand;
  private TankDriveCommand tankDriveCommand;
  private RobotContainer m_robotContainer;
  Thread m_visionThread;
  UsbCamera camera1;
  UsbCamera camera2;
  NetworkTableEntry cameraSelection;
  Joystick logitechController;
  VideoSink server;
  Joystick logitechController2;
  IntakeSubsystem intakeSubsystem;

  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer();
    logitechController = m_robotContainer.getJoystick();
    m_visionThread =
        new Thread(
            () -> {
              
              // Get the UsbCamera from CameraServer
              camera1 = CameraServer.startAutomaticCapture(1);
              camera2 = CameraServer.startAutomaticCapture(0);
            
              cameraSelection = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
              
              // Set the resolution
          
              server = CameraServer.getServer();

              
          
              // Get a CvSink. This will capture Mats from the camera
              CvSink cvSink = CameraServer.getVideo();
              // Setup a CvSource. This will send images back to the Dashboard
              CvSource outputStream = CameraServer.putVideo("DENEME", 720, 480);

              // Mats are very memory expensive. Lets reuse this Mat.
              Mat source = new Mat();
              Mat output = new Mat();


              // This cannot be 'true'. The program will never exit if it is. This
              // lets the robot stop this thread when restarting robot code or
              // deploying.
              while (!Thread.interrupted()) {
                // Tell the CvSink to grab a frame from the camera and put it
                // in the source mat.  If there is an error notify the output.
                if (cvSink.grabFrame(source) == 0) {

                  outputStream.notifyError(cvSink.getError());
                  // skip the rest of the current iteration
                  continue;
                }
            
                Imgproc.rectangle(
                  source, new Point(100, 100), new Point(400, 400), new Scalar(255, 255, 255), 5);
              // Give the output stream a new image to display
              outputStream.putFrame(output);
            }
              
            });
    m_visionThread.setDaemon(true);
    m_visionThread.start();
  }
  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("datatable");{
  xEntry = table.getEntry("X");
  yEntry = table.getEntry("Y");}

  
  double x = 0;
  double y = 0;

                  
  

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    

    // schedule the autonomous command (example)

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    tankDriveCommand = m_robotContainer.getTankDriveCommand();
    tankDriveCommand.schedule();
    }
  
  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    m_robotContainer.changeDirection();
    if (logitechController.getRawButtonPressed(5)) {
      System.out.println("Setting camera 2");
      cameraSelection.setString(camera2.getName());
  } else if (logitechController.getRawButtonReleased(5)) {
      System.out.println("Setting camera 1");
      cameraSelection.setString(camera1.getName());
  }
    xEntry.setDouble(x);
    yEntry.setDouble(y);
    x += 0.05;
    y += 1.0;
    // Tank drive with a given left and right rates
   

  
  }
  


  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}