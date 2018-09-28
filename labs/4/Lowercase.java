
public class Lowercase {

	public static void main(String[] args) {
		//97-122
		int rando;
		for (int n = 0; n < 5;n++) {
			for(int i=0;i<5;i++) {
				rando = (int)(Math.random()*123);
				while (rando < 97 || rando > 122) {
					rando = (int)(Math.random()*123);
				}
				System.out.print((char)(rando) + " ");
			}
			System.out.println();
		}
		}

	}
