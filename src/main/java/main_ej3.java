import org.jgroups.Address;

public class main_ej3 {

	public static void main(String[] args) throws Exception {
		Ejercicio03 sample = new Ejercicio03("Cluster");
		sample.start();
		int i = 0;
		for (Address target : sample.getMembers()) {
			sample.sendParticularMessageToSpecifiedTarget(target, "Mensaje "
					+ i);
			i++;

		}
	}

}
