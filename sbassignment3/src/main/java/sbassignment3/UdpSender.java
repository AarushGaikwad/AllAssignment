package sbassignment3;

public class UdpSender implements Sender {

	@Override
	public void send(double value) {
		System.out.println("UDP: " + value);	
	}

}
