// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Twist2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructPublisher;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FieldConstants;
import frc.robot.Constants.ShootingConstants;
import frc.robot.Constants.TurretConstants;

public class TurretSubsystem extends SubsystemBase {
  /** Creates a new TurretSubsystem. */
  CommandSwerveDrivetrain drivetrain;

  public static final StructPublisher<Pose2d> dispPub = NetworkTableInstance.getDefault()
        .getStructTopic("TargetDisplacement", Pose2d.struct)
        .publish();

  public static final StructPublisher<Pose2d> turretPub = NetworkTableInstance.getDefault()
        .getStructTopic("TurretPosition", Pose2d.struct)
        .publish();
  
  public TurretSubsystem(CommandSwerveDrivetrain drivetrain) {
    this.drivetrain = drivetrain;
  }

  @Override
  public void periodic() {
    dispPub.set(getTargetDisp());
    turretPub.set(getFutureFieldTurretPose(0.2));
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
