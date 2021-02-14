package hello.core.lifesycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class NetworkClient {

	private String url;

	public NetworkClient() {
		System.out.println("생성자 호출, url = "+url);
	}

	public void setUrl(String url) {
		System.out.println("NetworkClient.setUrl");
		this.url = url;
	}

	public void connect() {
		System.out.println("connect: "+url);
	}

	// 서비스 시작시 호출
	public void call(String message) {
		System.out.println("call: "+url +", message = "+message);
	}

	// 서비스 종료시 호출
	public void disconnect() {
		System.out.println("close: "+url);
	}

	@PostConstruct
	public void init() {
		System.out.println("NetworkClient.init");
		connect();
		call("초기화 연결 메시지");
	}

	@PreDestroy
	public void close() {
		System.out.println("NetworkClient.close");
		disconnect();
	}
}
