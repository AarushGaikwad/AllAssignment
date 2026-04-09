package sbassignment3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {
	
	@Primary
	@Bean
	public TcpSender tcp() {
		TcpSender tcp = new TcpSender();
		return tcp;
	}
	
	@Bean
	public UdpSender udp() {
		UdpSender udp = new UdpSender();
		return udp;
	}
	
	@Bean
	public HttpSender http() {
		HttpSender http = new HttpSender();
		return http;
	}
}
