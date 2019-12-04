
public class ExtraMethod {
	
	
	ExtraMethod(){
		
	}
	
	
	public boolean colrow (int[][]matrix,int nbr,int x,int y){
		for(int i=0; i<9; i++) {
			if(matrix[x][i]==nbr && y!=i) {
				return false;
			}
			if(matrix[i][y]==nbr && x!=i) {
				return false;
			}
		}
		int row = (x / 3) * 3;
		int col = (y / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if ((row + i != x && col + k != y) && matrix[row + i][col + k] == nbr) {
					return false;
				}
			}
		}
		
		return true;
	}
	

}
