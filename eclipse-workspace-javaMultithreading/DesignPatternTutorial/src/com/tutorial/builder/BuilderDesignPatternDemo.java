package com.tutorial.builder;

class Computer{
	private String hdd;
	private String RAM;
	private boolean isGraphicsEnabled;
	private boolean isBlueToothEnabled;
	
	public Computer(ComputerBuilder computerBuilder) {
		this.hdd = computerBuilder.hdd;
		this.RAM = computerBuilder.RAM;
		this.isGraphicsEnabled = computerBuilder.isGraphicsEnabled;
		this.isBlueToothEnabled = computerBuilder.isBlueToothEnabled;
	}
	
	public String getHdd() {
		return hdd;
	}
	public String getRAM() {
		return RAM;
	}
	public boolean isGraphicsEnabled() {
		return isGraphicsEnabled;
	}
	public boolean isBlueToothEnabled() {
		return isBlueToothEnabled;
	}

	
	
	static class ComputerBuilder{
		private String hdd;
		private String RAM;
		private boolean isGraphicsEnabled;
		private boolean isBlueToothEnabled;
		
		
		public ComputerBuilder(String RAM) {
			this.RAM = RAM;
		}


		public ComputerBuilder setHdd(String hdd) {
			this.hdd = hdd;
			return this;
		}

		public ComputerBuilder setGraphicsEnabled(boolean isGraphicsEnabled) {
			this.isGraphicsEnabled = isGraphicsEnabled;
			return this;
		}


		public ComputerBuilder setBlueToothEnabled(boolean isBlueToothEnabled) {
			this.isBlueToothEnabled = isBlueToothEnabled;
			return this;
		}
		
		
		
		public Computer build() {
			return new Computer(this);
		}
		
		
		
		
	}
	
	
	
	
}


public class BuilderDesignPatternDemo {
	
	
public static void main(String[] args) {
	new Computer.ComputerBuilder("tesla").setBlueToothEnabled(true).setGraphicsEnabled(true).setHdd("NewHDD").build();
	
	
}

}
