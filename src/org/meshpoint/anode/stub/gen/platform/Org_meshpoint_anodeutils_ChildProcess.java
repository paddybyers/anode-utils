/* This file has been automatically generated; do not edit */

package org.meshpoint.anode.stub.gen.platform;

public class Org_meshpoint_anodeutils_ChildProcess {

	private static Object[] __args = new Object[3];

	public static Object[] __getArgs() { return __args; }

	static Object __invoke(org.meshpoint.anodeutils.ChildProcess inst, int opIdx, Object[] args) {
		return inst.fork(
			(String)args[0],
			(String[])args[1],
			(org.meshpoint.anodeutils.NodeProcessListener)args[2]
		);
	}

}
