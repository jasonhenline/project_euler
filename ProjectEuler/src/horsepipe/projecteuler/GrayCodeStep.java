package horsepipe.projecteuler;

public class GrayCodeStep {
	public GrayCodeStep(boolean isTurnOn, int position) {
		this.isTurnOn = isTurnOn;
		this.position = position;
	}
	
	public boolean getIsTurnOn() {
		return isTurnOn;
	}
	
	public int getPosition() {
		return position;
	}
	
	private boolean isTurnOn;
	private int position;
}
