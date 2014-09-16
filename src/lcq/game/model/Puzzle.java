package lcq.game.model;

public class Puzzle {

	private static int dim; // 维度
	private Puzzle blocks[][]; // block集合

	// 禁止外部声明一个Puzzle实例
	private Puzzle() {
	}

	private Puzzle(int dim) {
		this.dim = dim;
		blocks = new Puzzle[dim][dim];
	}
	
	/**
	 * 生成一个Puzzle
	 * @param dim
	 * @return
	 */
	public static Puzzle generate(int dim){
		Puzzle p = new Puzzle(dim);
		
		return p;
	}
}
