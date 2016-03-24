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
		 *  Channel��ͨ����ͨ����һ�����������ݵ�ú��
		 *  	����ByteBuffer���洢δ�ӹ��ֽڵĻ�������������
		 *  	����������һ���󳵣�װ���˷�������ͨ��������װ����ͨ���ͳ������ݷ��ء�
		 */
		fc = new RandomAccessFile("test.txt", "rw").getChannel();
		
		/*
		 *  MappedByteBuffer��Ҳ��һ�ֻ�����������ָ��ӳ���ļ��е�һ����
		 *  	ӳ���start��start+LENGTH��һ���ַ�������ֻ�����˲��֣�
		 */
		MappedByteBuffer out = fc.map(MapMode.READ_WRITE, 0, LENGTH);
		// ����˳��ѹ��LENGTH���ַ�
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
				/*  FileLock : �˴�ֻ�ܻ��ͨ���ϵ��������ǻ������ϵ�
				 *  ��˼�ǿ���ͬʱ���������ͬʱ��д�����޷���ͨ����д����
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
