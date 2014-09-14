import org.jgroups.Message;
import org.jgroups.View;


public class Ejercicio02 extends Ejercicio1 {

	public Ejercicio02(String cluster) throws Exception {
		super(cluster);
	}
	
	public void viewAccepted(View new_view) {
		System.out.println("** view: " + new_view);
	}
	public void receive(Message msg) {
		System.out.println(msg.getSrc() + ": " + msg.getObject());
	}

}
