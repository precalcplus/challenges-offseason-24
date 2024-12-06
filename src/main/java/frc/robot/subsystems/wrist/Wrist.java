package frc.robot.subsystems.wrist;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wrist extends SubsystemBase {
  // For instructions on how to implement this class, refer to the README.md file
  private WristIO m_io;
  private PIDController m_controller;
  private WristInputsAutoLogged m_inputs;

  public Wrist(WristIO io, PIDController controller) {
    // TODO: Implement the constructor
    m_io = io;
    m_controller = controller;
    m_inputs = new WristInputsAutoLogged();
  }

  @Override
  public void periodic() {
    // TODO: Implement this method
    m_io.updateInputs(m_inputs);
    // m_inputs.getValueAsDouble();
    // double wristPidVoltage = m_controller.calculate(m_inputs);
    double wristPidVoltage = m_controller.calculate(m_io.getAngle().getDegrees(), 0);
    m_io.setVoltage(wristPidVoltage);
  }

  public void setDesiredAngle(Rotation2d angle) {
    // TODO: Implement this method
    m_controller.setSetpoint(angle.getRadians());
  }

  public Command setDesiredAngleCommand(Rotation2d angle) {
    // TODO: Implement this method
    return Commands.runOnce(() -> m_controller.setSetpoint(angle.getRadians()));
  }

  public boolean withinTolerance() {
    // TODO: Implement this method
    m_controller.getPositionTolerance();
    return true;
  }

  public WristInputsAutoLogged getInputs() {
    // TODO: Implement this method
    return m_inputs;
  }
}
