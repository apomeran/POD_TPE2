import org.jgroups.JChannel;
import org.jgroups.ReceiverAdapter;

public class Ejercicio1 extends ReceiverAdapter {

	JChannel channel;
	String cluster;

	public void start() throws Exception {
		channel.setReceiver(this);
		channel.connect(this.cluster);

	}

	public Ejercicio1(String cluster) throws Exception {
			this.channel = new JChannel();
			this.cluster = cluster;
	}

	public void sleep5SecondsAndDisconnect() throws InterruptedException {
		Thread.sleep(5000);
		disconnectChannel();
	}
	
	public void disconnectChannel(){
		this.channel.close();
		System.out.println("Disconnected");
	}

}
