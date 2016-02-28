package demo.designpattern;

import demo.BaseDemo;

public class Factory extends BaseDemo {
	interface Tree { void grow(); }
	interface TreeFactory { Tree getTree(); }
	
	static class TreeImpl implements Tree {
		private TreeImpl() {
			println("Plant an Oak");
		}
		public void grow() {
			println("grow slowly");
		}
		//Set factory here, the constructor can be private
		static TreeFactory factory = new TreeFactory() 
		{
			public Tree getTree() {
				return new TreeImpl();
			}
		};
	}
	
	static void plantTree(TreeFactory factory) {
		Tree tree = factory.getTree();
		tree.grow();
	}
	public static void main(String args[]) 
	{
		plantTree(TreeImpl.factory);
	}
}

