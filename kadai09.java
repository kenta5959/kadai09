public class TheDogTest1 {
	public static void main(String[] args) {
	Dog pochi = new Dog();
	pochi.print();
	pochi.roudou();
	pochi.print();
	pochi.roudou();
	pochi.print();
	（中略）
	}
	class Dog {
		private DogState myState;
		public Dog() {
		myState = neteiruState.getInstance();
		}
		public void roudou() {
		myState.tukareta(this);
		}
		public void neteiru() {
		myState.neta(this);
		}
		public void changeState(DogState d) {
			myState = d;
			}
			public void print() {
			System.out.print("現在、わたしは「");
			System.out.print( myState.toString() );
			System.out.println("」です。");
			}
			}
			abstract class DogState {
				public abstract void tukareta(Dog yobidashimoto);
				public abstract void neta(Dog yobidashimoto);
				}		
				class neteiruState extends DogState {
					private static neteiruState s = new neteiruState();
					private neteiruState() {}
					public static DogState getInstance() {
					return s;
					}
					public void tukareta(Dog moto) {
						moto.changeState(FutsuuState.getInstance());
						}
						public void neta(Dog moto) {
						// なにもしない
						}
						public String toString() {
						return "寝ている状態";
						}
						}	
						class FutsuuState extends DogState {
							private static FutsuuState s = new FutsuuState();
							private FutsuuState() {}
							public static DogState getInstance() {
							return s;
							}	
							public void tukareta(Dog moto) {
								moto.changeState(IrairaState.getInstance());
								}
								public void neta(Dog moto) {
								moto.changeState(neteiruState.getInstance());
								}
								public String toString() {
								return "普通状態";
								}
								}
								class IrairaState extends DogState {
									private static IrairaState s = new IrairaState();
									private IrairaState() {}
									public static DogState getInstance() {
									return s;
									}	
									public void tukareta(Dog moto) {
										// なにもしない
										}
										public void neta(Dog moto) {
										moto.changeState(neteiruState.getInstance());
										}
										public String toString() {
										return "いらいら状態";
										}
}	
				