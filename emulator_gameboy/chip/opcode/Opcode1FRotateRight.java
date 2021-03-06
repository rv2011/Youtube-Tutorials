package chip.opcode;

import chip.Flag;
import chip.Register;
import chip.Z80;

public class Opcode1FRotateRight implements IOpcode {

	@Override
	public void execute(Z80 gba) {
		int flagA = gba.getRegister(Register.A);
		int bitZero = flagA & 0x1;
		gba.resetFlagRegister();
		flagA = flagA >>> 1;
		flagA |= (gba.getRegister(Register.A) & 0x1) << 7;
		gba.setFlagRegister(Flag.Carry, bitZero == 1);
		gba.setFlagRegister(Flag.Zero, flagA == 0);
		gba.setRegister(Register.A, flagA);
	}

	@Override
	public int getCycleCount() {
		return 4;
	}

}
