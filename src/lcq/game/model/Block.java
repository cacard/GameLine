package lcq.game.model;

public class Block {
	
	public static int ROLE_TOUCHABLE=1; 	// ��ɫ:�ɵ���Ŀ�
	public static int ROLE_BARRIER=-1;		// ��ɫ:�ϰ���

	private int top;
	private int bottom;
	private int left;
	private int right;
	private int role=1;						// ��ɫ
	
	private boolean isInLine; 				// �Ƿ��ڼ���״̬���ѱ�����
	private int lineIndex; 				// �������е�����
	
	public Block(){
		role=1;
	}
	
	/**
	 * �ǲ��ǿ����ߵĿ�
	 * @return
	 */
	public boolean isTouchable(){
		return role==ROLE_TOUCHABLE;
	}
	
	/**
	 * �Ƿ����ϰ���
	 * @return
	 */
	public boolean isBarrier(){
		return role==ROLE_BARRIER;
	}
	
	/**
	 * �Ƿ�����
	 * @return
	 */
	public boolean isInLine(){
		return isInLine;
	}
	
	/**
	 * �������е�����
	 * @return
	 */
	public int getLineIndex(){
		return lineIndex;
	}
}
