package UseCases.ING;

import java.util.Optional;

public class UserStats {
	private Optional<Long> visitCount;

	
	
	public UserStats(Optional<Long> visitCount) {
		this.visitCount = visitCount;
	}



	public Optional<Long> getVisitCount() {
		return visitCount;
	}
}
