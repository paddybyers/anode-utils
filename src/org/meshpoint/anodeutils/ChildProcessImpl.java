package org.meshpoint.anodeutils;

import org.meshpoint.anode.AndroidContext;
import org.meshpoint.anode.module.IModule;
import org.meshpoint.anode.module.IModuleContext;

import android.content.Context;

public class ChildProcessImpl extends ChildProcess implements IModule {

	private Context androidContext;
	
	/*****************************
	 * IChildProcess methods
	 *****************************/

	@Override
	public NodeProcess fork(String modulePath, String[] argv, NodeProcessListener listener) {
		return new NodeProcessImpl(modulePath, argv, listener);
	}

	/*****************************
	 * IModule methods
	 *****************************/

	@Override
	public Object startModule(IModuleContext ctx) {
		androidContext = ((AndroidContext)ctx).getAndroidContext();
		/*
		 * perform any module initialisation here ...
		 */
		return this;
	}

	@Override
	public void stopModule() {
		/*
		 * perform any module shutdown here ...
		 */
	}

}
