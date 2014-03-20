package org.meshpoint.anodeutils;

import org.meshpoint.anode.bridge.Env;
import org.meshpoint.anode.java.Base;

public abstract class NodeProcess extends Base {
	private static short classId = Env.getInterfaceId(NodeProcess.class);
	protected NodeProcess() { super(classId); }

	public abstract void send(String msg);
	public abstract void kill(int sig);
}
