package com.search;

public class SearchPlatforms {
	private boolean hasPlatform;
	private int x;
	private int y;
	
	public SearchPlatforms(int x, int y, boolean hasPlatform) {
		this.setX(x);
		this.setY(y);
		this.setHasPlatform(hasPlatform);
	}

	public boolean hasPlatform() {
		return hasPlatform;
	}

	public void setHasPlatform(boolean hasPlatform) {
		this.hasPlatform = hasPlatform;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
