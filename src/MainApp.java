
public class MainApp {

	static ServerCom com;
	
	public static void main(String[] args) {
		System.out.println("[INICIANDO SERVIDOR]");
		com = new ServerCom();
		com.start();
		System.out.println("[SERVIDOR OK]");
	}

}
