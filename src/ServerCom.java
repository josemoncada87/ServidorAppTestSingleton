import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerCom extends Thread {

	private ServerSocket ss;
	private Socket s;

	public ServerCom() {
		try {
			ss = new ServerSocket(5000);
			s = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (s == null) {
					System.out.println("[ESPERANDO CLIENTE]");
					s = ss.accept();
					System.out.println("[CLIENTE CONECTADO]");
				} else {					
					recibirMensajes();
				}
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();				
			} catch (IOException e) {				
				System.out.println("[CLIENTE DESCONECTADO]");
				s = null;
			}
		}
	}

	private void recibirMensajes() throws IOException {
		DataInputStream in = new DataInputStream(s.getInputStream());
		System.out.println("[MENSAJE RECIBIDO] " + in.readUTF());
	}

}
