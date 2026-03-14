# swerve-thingie

A compact WPILib robot project implementing a swerve-drive base and common robot infrastructure for development, simulation, and deployment.
- Just a practice repo

## Quick start

1. Install WPILib and required toolchain.
2. Open the project in an IDE (VS Code, IntelliJ) that supports Gradle/WPILib.
3. Build:
    - >WPILib: Build Robot Code
4. Run simulator:
    - >WPILib: Simulate Robot Code
5. Deploy to robot (ensure robot IP configured):
    - >WPILib: Deploy Robot Code


## Swerve notes
- Contains modules for kinematics, odometry, and module controllers.
- Tune drive and steering PID values before running on hardware.
- Verify encoder/encoder offsets and invert settings for each module.

## Testing & Simulation
- Add unit tests under src/test and run with the command >WPILib: Simulate Robot Code
- Use WPILib simulator to validate autonomous and drive code without hardware
