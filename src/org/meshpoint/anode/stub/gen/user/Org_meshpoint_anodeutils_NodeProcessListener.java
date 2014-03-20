/* This file has been automatically generated; do not edit */

package org.meshpoint.anode.stub.gen.user;

public class Org_meshpoint_anodeutils_NodeProcessListener extends org.meshpoint.anode.js.JSInterface implements org.meshpoint.anodeutils.NodeProcessListener {

	private static int classId = org.meshpoint.anode.bridge.Env.getInterfaceId(org.meshpoint.anodeutils.NodeProcessListener.class);

	Org_meshpoint_anodeutils_NodeProcessListener(long instHandle) { super(instHandle); }

	public void finalize() { super.release(classId); }

	private static Object[] __args = new Object[1];

	public void onExit(int arg0) {
		__args[0] = org.meshpoint.anode.js.JSValue.asJSNumber((long)arg0);
		__invoke(classId, 0, __args);
	}

	public void onMessage(String arg0) {
		__args[0] = arg0;
		__invoke(classId, 1, __args);
	}

}
