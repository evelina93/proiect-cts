package classes;

public class OutcomeEvent {

	private String eventId;
	private String outcome;
	
	
	
	public OutcomeEvent() {
	}

	public OutcomeEvent(String eventId, String outcome) {
		this.eventId = eventId;
		this.outcome = outcome;
	}

	public String getEventId() {
		return eventId;
	}

	public String getOutcome() {
		return outcome;
	}

	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OutcomeEvent other = (OutcomeEvent) obj;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (outcome == null) {
			if (other.outcome != null)
				return false;
		} else if (!outcome.equals(other.outcome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OutcomeEvent [eventId=" + eventId + ", outcome=" + outcome + "]";
	}
	
	
	
}
