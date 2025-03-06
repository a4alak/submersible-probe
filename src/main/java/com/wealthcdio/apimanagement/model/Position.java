package com.wealthcdio.apimanagement.model;

public class Position {

	private int x_axix;
	private int y_axix;

	public Position(int x_axix, int y_axix) {
		this.x_axix = x_axix;
		this.y_axix = y_axix;
	}

	public int getX_axix() {
		return x_axix;
	}

	public int getY_axix() {
		return y_axix;
	}

	@Override
	public String toString() {
		return "Position [x_axix=" + x_axix + ", y_axix=" + y_axix + "]";
	}

	
}
