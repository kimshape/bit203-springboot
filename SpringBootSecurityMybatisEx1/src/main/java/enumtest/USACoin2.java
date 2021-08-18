package enumtest;

public enum USACoin2 {
	PENNY(1) ,
	NICKLE(5),
	DIME(10),
	QUARTER(25);
	
	private int value;
	private USACoin2(int i) {
		System.out.println("USACoin2  "+i);
		value = i;
	}
	//The constructor USACoin2(int) is undefined
	public int getValue() {
		return value;
	}
	
}
