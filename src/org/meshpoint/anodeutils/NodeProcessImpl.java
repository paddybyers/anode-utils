package org.meshpoint.anodeutils;

import org.meshpoint.anode.Isolate;
import org.meshpoint.anode.Runtime.IllegalStateException;
import org.meshpoint.anode.Runtime.NodeException;
import org.meshpoint.anode.Runtime.StateListener;

public class NodeProcessImpl extends NodeProcess {

	/*****************************
	 * NodeProcess methods
	 *****************************/

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill(int sig) {
		if(isolate != null && isolate.getState() == org.meshpoint.anode.Runtime.STATE_STARTED) {
			try {
				isolate.stop();
			} catch (Throwable t) {
				throw new AnodeException(t);
			}
			return;
		}

		throw new AnodeException(new IllegalStateException(
				"Attempting to kill NodeProcess when not in STARTED state"
			));
	}

	/*****************************
	 * Internal
	 *****************************/

	NodeProcessImpl(String modulePath, String[] argv, final NodeProcessListener listener) {
		this.listener = listener;
		try {
			isolate = org.meshpoint.anode.Runtime.createIsolate();
			if(listener != null) {
				isolate.addStateListener(new StateListener() {
					@Override
					public void stateChanged(int state) {
						if(state == org.meshpoint.anode.Runtime.STATE_STOPPED)
							try {
								listener.onExit(isolate.getExitval());
							} catch (IllegalStateException e) {}
					}
				});
			}
			String[] isolateArgv;
			if(argv != null && argv.length > 0) {
				isolateArgv = new String[argv.length + 1];
				isolateArgv[0] = modulePath;
				System.arraycopy(argv, 0, isolateArgv, 1, argv.length);
			} else {
				isolateArgv = new String[]{modulePath};
			}
			isolate.start(isolateArgv);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private NodeProcessListener listener;
	private Isolate isolate;
}
