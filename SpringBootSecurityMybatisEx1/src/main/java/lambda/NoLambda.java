package lambda;

public class NoLambda {
	static Operator add = new Operator() {//익명inner
		
		@Override
		public int calc(int a, int b) {
			// TODO Auto-generated method stub
			return a+b;
		}
	};
	
	public static class 뺄쌤 implements Operator{//명시된 inner

		@Override
		public int calc(int a, int b) {
			// TODO Auto-generated method stub
			return a-b;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(add.calc(7, 7));
		뺄쌤 min = new 뺄쌤();
		System.out.println(min.calc(234, 23));
		
		Operator mult = new Operator() {
			
			@Override
			public int calc(int a, int b) {
				// TODO Auto-generated method stub
				return a*b;
			}
		};
		
		
		System.out.println(mult.calc(234, 23));
		
		
	}
}












