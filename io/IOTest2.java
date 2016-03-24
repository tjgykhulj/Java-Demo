package demo.io;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.channels.FileChannel.MapMode;

public class IOTest2 {

	static final int LENGTH = 0xFF;
	static FileChannel fc;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		/*
		 *  Channel：通道，通道是一个包含了数据的煤矿，
		 *  	仅与ByteBuffer（存储未加工字节的缓冲器）相连，
		 *  	缓冲器就像一个矿车，装完了发车送入通道，或者装满从通道送出的数据返回。
		 */
		fc = new RandomAccessFile("test.txt", "rw").getChannel();
		
		/*
		 *  MappedByteBuffer：也是一种缓冲器，可以指定映射文件中的一部分
		 *  	映射从start到start+LENGTH的一段字符。（即只操作此部分）
		 */
		MappedByteBuffer out = fc.map(MapMode.READ_WRITE, 0, LENGTH);
		// 将按顺序压入LENGTH个字符
		for (int i=0; i<LENGTH; i++) out.put((byte)'b');
		
		new LockAndModify(out, 0, LENGTH/3);
		new LockAndModify(out, LENGTH/2, LENGTH/2 + LENGTH/4);
	}
	
	private static class LockAndModify extends Thread 
	{
		private ByteBuffer buff;
		private int position, size;
		
		LockAndModify(ByteBuffer mbb, int start, int end) {
			position = start;
			size = end - start;
			mbb.limit(end);
			mbb.position(start);
			buff = mbb.slice();
			start();
		}
		@Override
		public void run() {
			try {
				/*  FileLock : 此处只能获得通道上的锁，而非缓存器上的
				 *  意思是可以同时多个缓存器同时读写，但无法向通道读写数据
				 */
				
				FileLock fl = fc.lock(position, size, false);
				System.out.println("Locked: "+position+" to "+(position+size)); 
				while (buff.position() < buff.limit() - 1)
					buff.put((byte) (buff.get()+1));
				fl.release();
				System.out.println("Released: "+position+" to "+(position+size)); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
