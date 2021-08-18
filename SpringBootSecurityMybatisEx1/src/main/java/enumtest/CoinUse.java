package enumtest;

import a.enumtest.USACoinVO;
import lombok.val;

public class CoinUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coin = 5;
		String coinStr="";
		
		switch (coin) {
		case USACoinVO.PENNY:
			coinStr="PENNY";
			break;
		case USACoinVO.NICKLE:
			coinStr="NICKLE";
			break;
		case USACoinVO.DIME:
			coinStr="DIME";
			break;
		case USACoinVO.QUARTER:
			coinStr="QUARTER";
			break;
		}
		System.out.printf("USACoinVO 클래스 사용 : %d , %s \n",coin,coinStr);
		
		switch (coin) {
		case USACoinService.PENNY:
			coinStr="PENNY";
			break;
		case USACoinService.NICKLE:
			coinStr="NICKLE";
			break;
		case USACoinService.DIME:
			coinStr="DIME";
			break;
		case USACoinService.QUARTER:
			coinStr="QUARTER";
			break;
		}
		System.out.printf("USACoinService 인터페이스 사용 : %d , %s \n",coin,coinStr);
		
		USACoin usaCoin = USACoin.NICKLE;
		
		System.out.println( USACoin.PENNY.ordinal()+""+usaCoin);
		
		for( USACoin  value   :  USACoin.values()    ) {
			System.out.println( value  );
			String str = value.name();
			System.out.println("value.name() "+str);
			System.out.println(value.compareTo(usaCoin));
		}
		
		System.out.println("////////////////////////////");
		USACoin2 usaCoin2= USACoin2.NICKLE;
		
		System.out.println(usaCoin2);
		System.out.println(usaCoin2.name());
		System.out.println(usaCoin2.getValue());
		
		
		
		
		
		
	}//main() end

}