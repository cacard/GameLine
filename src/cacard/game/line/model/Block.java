package cacard.game.line.model;

public class Block {

	public static int ROLE_TOUCHABLE = 1; // ��ɫ:�ɵ���Ŀ�
	public static int ROLE_START = 2; // ��ɫ:���
	public static int ROLE_NULL = 0; // ��ɫ:δָ��
	public static int ROLE_BARRIER = -1; // ��ɫ:�ϰ���

	private int role = ROLE_NULL; // ��ɫ
	private boolean isInLine; // �Ƿ��ڼ���״̬���ѱ�����
	private int lineIndex; // �������е�����

	public Block() {
		setRole(ROLE_NULL);
	}

	/**
	 * �ǲ��ǿ����ߵĿ飬ROLE_TOUCHABLE��ROLE_START������
	 * 
	 * @return
	 */
	public boolean isTouchable() {
		return role == ROLE_TOUCHABLE || role == ROLE_START;
	}

	/**
	 * �Ƿ����ϰ���
	 * 
	 * @return
	 */
	public boolean isBarrier() {
		return getRole() == ROLE_BARRIER;
	}

	/**
	 * �Ƿ�����
	 * 
	 * @return
	 */
	public boolean isInLine() {
		return isInLine;
	}

	/**
	 * �������е�����
	 * 
	 * @return
	 */
	public int getLineIndex() {
		return lineIndex;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
