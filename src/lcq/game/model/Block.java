package lcq.game.model;

public class Block {
	
	public static int ROLE_TOUCHABLE=1; 	// 橘色:可点击的块
	public static int ROLE_BARRIER=-1;		// 角色:障碍物

	private int top;
	private int bottom;
	private int left;
	private int right;
	private int role=1;						// 角色
	
	private boolean isInLine; 				// 是否处于激活状态，已被连线
	private int lineIndex; 				// 在连线中的索引
	
	public Block(){
		role=1;
	}
	
	/**
	 * 是不是可连线的块
	 * @return
	 */
	public boolean isTouchable(){
		return role==ROLE_TOUCHABLE;
	}
	
	/**
	 * 是否是障碍物
	 * @return
	 */
	public boolean isBarrier(){
		return role==ROLE_BARRIER;
	}
	
	/**
	 * 是否被连线
	 * @return
	 */
	public boolean isInLine(){
		return isInLine;
	}
	
	/**
	 * 在连线中的索引
	 * @return
	 */
	public int getLineIndex(){
		return lineIndex;
	}
}
