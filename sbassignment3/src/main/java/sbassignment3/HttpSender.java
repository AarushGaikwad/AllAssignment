package sbassignment3;

public class HttpSender implements Sender {

	@Override
	public void send(double value) {
		System.out.println("HTTP: " + value);
		
	}

}
