package be.pxl.computerstore.util;

public interface Computable {
	int BTW = 21;

	double totalPriceExcl();

	default double totalPriceIncl() {
		return totalPriceExcl() * (1 + BTW / 100.0);
	}

} //Failure bij: ComputerSystemComputableTest
// Expected: 75.7	but was: 75.0
