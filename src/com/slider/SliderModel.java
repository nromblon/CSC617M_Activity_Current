package com.slider;

import java.util.Random;

public class SliderModel {
	
	private int[][] map;
	
	public SliderModel() {
		this.map = new int[4][4];
		this.initializeMap();
		this.shuffleMap();
	}
	
	private void initializeMap() {
		int counter = 0;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				this.map[i][j] = counter;
				counter++;
			}
		}
	}
	
	private void shuffleMap() {
		int curr_x = 3;
		int curr_y = 3;
		int temp = 0;
		
		for(int i = 0; i < 120; i++) {
			Random rand = new Random();
			int nextMove = rand.nextInt(4) + 1;
			
			switch(nextMove) {
			case 1: //Move Up
				if(curr_y-1 > -1) {
					temp = this.map[curr_x][curr_y];
					this.map[curr_x][curr_y] = this.map[curr_x][curr_y-1];
					this.map[curr_x][curr_y-1] = temp;
					
					curr_y -= 1;
				}
				else
					continue;
				
				break;
			
			case 2: //Move Left
				if(curr_x-1 > -1) {
					temp = this.map[curr_x][curr_y];
					this.map[curr_x][curr_y] = this.map[curr_x-1][curr_y];
					this.map[curr_x-1][curr_y] = temp;
					
					curr_x -= 1;
				}
				else
					continue;
				
				break;
				
			case 3: //Move Down
				if(curr_y+1 < 4) {
					temp = this.map[curr_x][curr_y];
					this.map[curr_x][curr_y] = this.map[curr_x][curr_y+1];
					this.map[curr_x][curr_y+1] = temp;
					
					curr_y += 1;
				}
				else
					continue;
				
				break;
				
			case 4: //Move Right
				if(curr_x+1 < 4) {
					temp = this.map[curr_x][curr_y];
					this.map[curr_x][curr_y] = this.map[curr_x+1][curr_y];
					this.map[curr_x+1][curr_y] = temp;
					
					curr_x += 1;
				}
				break;
				
			default:
				break;
			}
		}
	}
	
	public void updateMap(Movement move, int i, int j) {
		int temp = 0;
		
		switch(move) {
			case UP: {
				temp = this.map[i][j];
				this.map[i][j] = this.map[i][j-1];
				this.map[i][j-1] = temp;
				break;
			}
			case RIGHT: {
				temp = this.map[i][j];
				this.map[i][j] = this.map[i+1][j];
				this.map[i+1][j] = temp;
				break;
			}
			case DOWN: {
				temp = this.map[i][j];
				this.map[i][j] = this.map[i][j+1];
				this.map[i][j+1] = temp;
				break;
			}
			case LEFT: {
				temp = this.map[i][j];
				this.map[i][j] = this.map[i-1][j];
				this.map[i-1][j] = temp;
				break;
			}
			case NONE: {
				break;
			}
			default:
				break;
		}
	}
	
	public boolean isGameOver() {
		boolean isSolved = true;
		int counter = 0;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				if(this.map[i][j] == counter) {
					counter++;
					continue;
				}
				else {
					isSolved = false;
					break;
				}
			}
		}
		
		return isSolved;
	}
	
	public int[][] getMap() {
		return this.map;
	}
	
}
