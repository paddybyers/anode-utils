package org.meshpoint.anodeutils;

import org.meshpoint.anode.bridge.Env;
import org.meshpoint.anode.java.Base;

public abstract class ChildProcess extends Base {
	private static short classId = Env.getInterfaceId(ChildProcess.class);
	protected ChildProcess() { super(classId); }

	public abstract NodeProcess fork(String modulePath, String[] argv, NodeProcessListener listener);
}
