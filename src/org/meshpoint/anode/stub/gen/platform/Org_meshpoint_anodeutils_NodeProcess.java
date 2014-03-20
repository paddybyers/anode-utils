/* This file has been automatically generated; do not edit */

package org.meshpoint.anode.stub.gen.platform;

public class Org_meshpoint_anodeutils_NodeProcess {

	private static Object[] __args = new Object[1];

	public static Object[] __getArgs() { return __args; }

	static Object __invoke(org.meshpoint.anodeutils.NodeProcess inst, int opIdx, Object[] args) {
		Object result = null;
		switch(opIdx) {
		case 0: /* kill */
			inst.kill(
				(int)((org.meshpoint.anode.js.JSValue)args[0]).longValue
			);
			break;
		case 1: /* send */
			inst.send(
				(String)args[0]
			);
			break;
		default:
		}
		return result;
	}

}
