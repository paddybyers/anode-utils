package org.meshpoint.anodeutils;

public interface NodeProcessListener {
	public void onExit(int code);
	public void onMessage(String msg);
}
