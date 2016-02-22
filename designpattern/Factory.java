package demo.designpattern;

import demo.BaseDemo;

public class Factory extends BaseDemo {
	interface Tree { void grow(); }
	interface TreeFactory { Tree getTree(); }
	
	static class TreeOak implements Tree {
		TreeOak() {
			println("Plant an Oak");
		}
		public void grow() {
			println("grow slowly");
		}
	}
	static class TreeOakFactory implements TreeFactory {
		public Tree getTree() {
			return new TreeOak();
		}
	}
	
	static void plantTree(TreeFactory factory) {
		Tree tree = factory.getTree();
		tree.grow();
	}
	public static void main(String args[]) 
	{
		plantTree(new TreeOakFactory());
	}
}
