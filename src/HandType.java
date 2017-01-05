
public class HandType {
	public enum Types {
		Single, Double, Triple, Bomb, Killer, Run, Suited_Run
	}
	
	private String name;
	private Integer count;
	private boolean isRun;
	private boolean isSuited;
	
	public HandType() {
		this.setName(Types.Single.toString());
		this.count = 1;
		this.isRun = false;
		this.isSuited = false;
	}
	
	// for continuing a game?
	public HandType(String name, Integer count, boolean isRun, boolean isSuited) {
		this.setName(name);
		this.setCount(count);
		this.setRun(isRun);
		this.setSuited(isSuited);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public boolean isRun() {
		return isRun;
	}

	public void setRun(boolean isRun) {
		this.isRun = isRun;
	}

	public boolean isSuited() {
		return isSuited;
	}

	public void setSuited(boolean isSuited) {
		this.isSuited = isSuited;
	}
}

