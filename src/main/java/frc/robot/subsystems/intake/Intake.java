package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  // For instructions on how to implement this class, refer to the README.md file

  public Intake(IntakeIO io) {
    // TODO: Implement the constructor
    IntakeIO m_io = new IntakeIO();
    IntakeInputsAutoLogged m_inputs = new IntakeInputsAutoLogged();
  }

  @Override
  public void periodic() {
    // TODO: Implement this method
    IntakeIO m_io.updateInputs(IntakeInputs inputs);
  }

  public void setRollerVoltage(double voltage) {
    // TODO: Implement this method
  }

  public Command setVoltageCommand(double voltage) {
    // TODO: Implement this method
    return null;
  }

  public IntakeInputsAutoLogged getInputs() {
    // TODO: Implement this method
    return null;
  }
}
