package sbassignment3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		
		TcpSender t = (TcpSender) ctx.getBean("tcp");
		t.send(85.21);
		
		UdpSender u = (UdpSender) ctx.getBean("udp");
		u.send(99.32);
		
		HttpSender h = (HttpSender) ctx.getBean("http");
		h.send(55.21);
		
		Sender s = ctx.getBean(Sender.class);
		System.out.println("calling sender interface");
		s.send(459.23);

	}

}
