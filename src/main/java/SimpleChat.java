import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

public class SimpleChat extends ReceiverAdapter {

	JChannel channel;
	String user_name = System.getProperty("user.name", "alan2");

	private void start() throws Exception {
		channel = new JChannel(); // use the default config, udp.xml
		channel.setReceiver(this);
		channel.connect("ChatCluster");

		eventLoop();
		channel.close();
	}

	public static void main(String[] args) throws Exception {
		new SimpleChat().start();
	}

	private void eventLoop() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				System.out.print("> ");
				System.out.flush();
				String line = in.readLine().toLowerCase();
				if (line.startsWith("quit") || line.startsWith("exit"))
					break;
				Message msg;
				if (line.startsWith("#")) {
					List<Address> members = channel.getView().getMembers();
					msg = new Message(null, null, line);
					for (Address address : members) {
						if (address
								.toString()
								.toLowerCase()
								.equals(line.substring(1,
										address.toString().length() + 1)
										.toLowerCase())) {
							line = line + " (Mensaje Particular)";
							msg = new Message(
									address,
									null,
									line.substring(address.toString().length() + 2));
							System.out.flush();
						}
					}

				} else {
					System.out.flush();

					line = "[" + user_name + "] " + line + " (Broadcast) ";
					msg = new Message(null, null, line);
				}
				channel.send(msg);
			} catch (Exception e) {
			}
		}
	}

	public void viewAccepted(View new_view) {
		System.out.println("** view: " + new_view);
	}

	public void receive(Message msg) {
		System.out.println(msg.getSrc() + ": " + msg.getObject());
	}
}