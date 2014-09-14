import java.util.List;

import org.jgroups.Address;
import org.jgroups.Message;

public class Ejercicio03 extends Ejercicio02 {
	String user_name = System.getProperty("user.name", "User #1");

	public Ejercicio03(String cluster) throws Exception {
		super(cluster);
	}

	public List<Address> getMembers() {
		return channel.getView().getMembers();

	}

	public void sendParticularMessage(String message) throws Exception {
		List<Address> members = channel.getView().getMembers();
		Address target = members.get(0);
		Message msg = new Message(target, null, message);
		channel.send(msg);
	}

	public void sendParticularMessageToSpecifiedTarget(Address target,
			String message) throws Exception {
		Message msg = new Message(target, null, message);
		channel.send(msg);
	}
}
