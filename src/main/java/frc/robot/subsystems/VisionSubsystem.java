// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructPublisher;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FieldConstants;
import frc.robot.Constants.VisionConstants;

public class VisionSubsystem extends SubsystemBase {
  /** Creates a new VisionSubsystem. */
  CommandSwerveDrivetrain drivetrain;

  private final StructPublisher<Pose2d> transPub = NetworkTableInstance.getDefault()
        .getStructTopic("Vision/TargetDisplacement", Pose2d.struct) 
        .publish();
  
  public VisionSubsystem(CommandSwerveDrivetrain drivetrain) {
    this.drivetrain = drivetrain;
  }

  @Override
  public void periodic() {
    transPub.set(getTargetDisp());
  }

  public Pose2d getTargetDisp() {
    Pose2d targetPose = new Pose2d(FieldConstants.getAlliancePositions()[FieldConstants.HUB_X_INDEX], FieldConstants.getAlliancePositions()[FieldConstants.HUB_Y_INDEX], new Rotation2d());
    
    double dist2Target = drivetrain.getState().Pose.getTranslation().getDistance(targetPose.getTranslation());
    double fuelTravelTime = VisionConstants.DIST_TIME_MAP.get(dist2Target);

    double correctionX = drivetrain.getState().Speeds.vxMetersPerSecond * fuelTravelTime;
    double correctionY = drivetrain.getState().Speeds.vyMetersPerSecond * fuelTravelTime;

    return new Pose2d(
        targetPose.getX() + correctionX,
        targetPose.getY() + correctionY,
        new Rotation2d()
    );
  }
}
