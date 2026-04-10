// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Twist2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructPublisher;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.FieldConstants;
import frc.robot.Constants.ShootingConstants;
import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.CommandSwerveDrivetrain;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PrepareShooter extends Command {
  /** Creates a new GetReadyToShootCommand. */
  private CommandSwerveDrivetrain drivetrain;

  public static final StructPublisher<Pose2d> dispPub = NetworkTableInstance.getDefault()
        .getStructTopic("TargetDisplacement", Pose2d.struct)
        .publish();

  public static final StructPublisher<Pose2d> turretPub = NetworkTableInstance.getDefault()
        .getStructTopic("TurretPosition", Pose2d.struct)
        .publish();

  public PrepareShooter(CommandSwerveDrivetrain drivetrain) {
    addRequirements(drivetrain);
    this.drivetrain = drivetrain;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Preparing shooter aaa...");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Preparing shooter...");
    Pose2d targetDisp = getTargetDisp();
    dispPub.set(targetDisp);
    Pose2d turretPose = getFutureFieldTurretPose(0.2);
    turretPub.set(turretPose);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

  public Pose2d getFutureFieldTurretPose(double lookAheadTime) {
      Pose2d currentRobotPose = drivetrain.getState().Pose;
      ChassisSpeeds speeds = drivetrain.getState().Speeds;

      Pose2d futureRobotPose = currentRobotPose.exp(
          new Twist2d(
              speeds.vxMetersPerSecond * lookAheadTime,
              speeds.vyMetersPerSecond * lookAheadTime,
              speeds.omegaRadiansPerSecond * lookAheadTime
          )
      );

      Pose2d futurePivotFieldPos = futureRobotPose.plus(
          TurretConstants.turretTransform);
      return futurePivotFieldPos;
  }

  public static Pose2d getFutureFieldTurretPose(CommandSwerveDrivetrain drivetrain, double lookAheadTime) {
      Pose2d currentRobotPose = drivetrain.getState().Pose;
      ChassisSpeeds speeds = drivetrain.getState().Speeds;

      Pose2d futureRobotPose = currentRobotPose.exp(
          new Twist2d(
              speeds.vxMetersPerSecond * lookAheadTime,
              speeds.vyMetersPerSecond * lookAheadTime,
              speeds.omegaRadiansPerSecond * lookAheadTime
          )
      );

      Pose2d futurePivotFieldPos = futureRobotPose.plus(
          TurretConstants.turretTransform);
      return futurePivotFieldPos;
  }

  public Pose2d getTargetDisp() {
    Translation2d targetPose = FieldConstants.getHubPosition();
    double dist2Target = drivetrain.getState().Pose.getTranslation().getDistance(targetPose);
    double fuelTravelTime = ShootingConstants.DIST_TIME_MAP.get(dist2Target);

    double correctionX = drivetrain.getState().Speeds.vxMetersPerSecond * fuelTravelTime;
    double correctionY = drivetrain.getState().Speeds.vyMetersPerSecond * fuelTravelTime;

    return new Pose2d(
        targetPose.getX() - correctionX,
        targetPose.getY() - correctionY,
        new Rotation2d()
    );
  }

  public static Pose2d getTargetDisp(CommandSwerveDrivetrain drivetrain) {
    Translation2d targetPose = FieldConstants.getHubPosition();
    double dist2Target = drivetrain.getState().Pose.getTranslation().getDistance(targetPose);
    double fuelTravelTime = ShootingConstants.DIST_TIME_MAP.get(dist2Target);

    double correctionX = drivetrain.getState().Speeds.vxMetersPerSecond * fuelTravelTime;
    double correctionY = drivetrain.getState().Speeds.vyMetersPerSecond * fuelTravelTime;

    return new Pose2d(
        targetPose.getX() - correctionX,
        targetPose.getY() - correctionY,
        new Rotation2d()
    );
  }
}
