package hrishabh;

public class UserSession1 {
	public UserSession1(final int amount) {
			Amount = amount;
			
		
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		amount = Amount;
		
		
		
	}
	private final int Amount;
	public static int getActiveSession() {
		return activeSession;
	}
	public static void setActiveSession(final int withActiveSession) {
		activeSession = withActiveSession;
	}

	private static int activeSession;
}



