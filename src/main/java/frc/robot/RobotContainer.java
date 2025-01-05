// Copyright 2021-2024 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.oi.DriverControls;
import frc.robot.oi.DriverControlsXbox;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.FlywheelIONeo;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
@SuppressWarnings("unused")
public class RobotContainer {
  // For instructions on how to implement this class, refer to the README.md file
  // Subsystems
  // TODO: Implement the flywheel subsystem

  // Controller
  private DriverControls m_driverControls;
  Flywheel m_flywheel;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureSubsystems();
    configureControllers();
    configureButtonBindings();
  }

  private void configureSubsystems() {
    // TODO: Implement this method

    // double kVelocitySetpoint = 24.2;

    m_flywheel = new Flywheel(new FlywheelIONeo(1), new PIDController(0.8, 0.0, 0.04));
  }

  private void configureControllers() {
    m_driverControls = new DriverControlsXbox(1);
  }

  private void configureButtonBindings() {
    // TODO: Implement this method
    m_driverControls
        .runFlywheel()
        .onTrue(
            // Commands.runOnce(
            // () -> {
            m_flywheel.setDesiredVelocityCommand(Constants.FlywheelConstants.kVelocitySetpoint))
        .onFalse(
            // Commands.runOnce(
            // () -> {
            m_flywheel.setDesiredVelocityCommand(0.0));
  }
}
