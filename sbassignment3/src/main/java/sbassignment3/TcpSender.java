package sbassignment3;

public class TcpSender implements Sender {

	@Override
	public void send(double value) {
		System.out.println("TCP: " + value);
	}

}
