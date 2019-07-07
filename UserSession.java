package hrishabh;

import java.util.Date;

public class UserSession {
	
	public UserSession(final int withUserId, final Date withLoginTime) {
		userId = withUserId;
		loginTime = withLoginTime;
	}
	public int getUserId() {
		return userId;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	
	private final int userId;
	private final Date loginTime;
	
	
	public static UserSession getActiveSession() {
		return activeSession;
	}
	public static void setActiveSession(final UserSession withActiveSession) {
		activeSession = withActiveSession;
	}

	private static UserSession activeSession;
}

