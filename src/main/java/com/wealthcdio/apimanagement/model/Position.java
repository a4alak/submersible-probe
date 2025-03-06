package com.wealthcdio.apimanagement.model;

import java.util.Objects;

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Position position = (Position) obj;
		return x_axix == position.x_axix && y_axix == position.y_axix;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x_axix, y_axix);
	}

	@Override
	public String toString() {
		return "Position [x_axix=" + x_axix + ", y_axix=" + y_axix + "]";
	}

}
