package lambda;

public class LambdaMakeUse2 {
	public void exec(Operator op) {
		int k = 10;
		int m = 20;
		int value = op.calc(k, m);
		System.out.println(k + ", " + m + ", " + value);
	}

	public static void main(String[] args) {
		LambdaMakeUse2 use2 = new LambdaMakeUse2();
		use2.exec(new Operator() {
			@Override
			public int calc(int a, int b) {
				return a + b;
			}
		});
		use2.exec(  (i,j) ->           i + j	);
		use2.exec(  (i,j) -> {	return i + j;	});
		
		
		
	}
}
