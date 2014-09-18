package lcq.game.line.model;

public class Block {

	public static int ROLE_TOUCHABLE = 1; // 角色:可点击的块
	public static int ROLE_START = 2; // 角色:起点
	public static int ROLE_NULL = 0; // 角色:未指定
	public static int ROLE_BARRIER = -1; // 角色:障碍物

	private int role = ROLE_NULL; // 角色
	private boolean isInLine; // 是否处于激活状态，已被连线
	private int lineIndex; // 在连线中的索引

	public Block() {
		setRole(ROLE_NULL);
	}

	/**
	 * 是不是可连线的块
	 * 
	 * @return
	 */
	public boolean isTouchable() {
		return getRole() == ROLE_TOUCHABLE;
	}

	/**
	 * 是否是障碍物
	 * 
	 * @return
	 */
	public boolean isBarrier() {
		return getRole() == ROLE_BARRIER;
	}

	/**
	 * 是否被连线
	 * 
	 * @return
	 */
	public boolean isInLine() {
		return isInLine;
	}

	/**
	 * 在连线中的索引
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
