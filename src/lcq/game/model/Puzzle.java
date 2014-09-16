package lcq.game.model;

public class Puzzle {

	private static int dim; // ά��
	private Puzzle blocks[][]; // block����

	// ��ֹ�ⲿ����һ��Puzzleʵ��
	private Puzzle() {
	}

	private Puzzle(int dim) {
		this.dim = dim;
		blocks = new Puzzle[dim][dim];
	}
	
	/**
	 * ����һ��Puzzle
	 * @param dim
	 * @return
	 */
	public static Puzzle generate(int dim){
		Puzzle p = new Puzzle(dim);
		
		return p;
	}
}
