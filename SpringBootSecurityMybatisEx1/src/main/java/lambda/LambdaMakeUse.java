package lambda;

public class LambdaMakeUse {
	public static void main(String[] args) {
		Operator mult = new Operator() {

			@Override
			public int calc(int a, int b) {
				// TODO Auto-generated method stub
				return a * b;
			}
		};
		System.out.println(mult.calc(234, 23));
		
		Operator mult2 = /*new Operator() {

			@Override
			public int calc*/(int a, int b) -> {
				// TODO Auto-generated method stub
				return a * b;
			}
		/* } */;
		
		System.out.println(mult2.calc(234, 23));
	}
}
