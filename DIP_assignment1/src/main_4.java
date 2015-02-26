public class main_4 {

	public static void main(String[] args) {
		String fileGrid, fileDisgrid, fileLena;
		fileDisgrid = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\distgrid.pgm";
		fileLena = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\distlenna.pgm";
		fileGrid = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\grid.pgm";
		int[][] picGrid = func.getPGMdata(fileGrid);
		int[][] picDisgrid = func.getPGMdata(fileDisgrid);
		int[][] picLena = func.getPGMdata(fileLena);
		int[][] newPic = new int[picLena.length][picLena[0].length];
		
		// Convolute to find cross point in grid file
		int[][] F = new int[picGrid.length][picGrid[0].length];
		for (int row = 0; row < picGrid.length; row++) {
	        for (int col = 0; col < picGrid[0].length; col++) {
	        	F[row][col] = 255 - picGrid[row][col];
	        }
	    }
		int[][] G = new int[][]{
				  { 0, 1, 0 },
				  { 1, 1, 1 },
				  { 0, 1, 0 }};
		int[][] C = new int[picGrid.length][picGrid[0].length];
		C = func.convoluteOriginCenter(F, G);
		
		String fileNameout = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\4GridConvolute.pgm";
		func.writePGMfile(fileNameout, C);
		
		int[][][] gridXY = new int[17][17][2];
		int[][][] disgridXY = func.disgridXY;
		gridXY = func.findGridXY(C);
		
		newPic = func.controlGrid(gridXY, disgridXY, picDisgrid);
		fileNameout = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\4disgridAfter.pgm";
		func.writePGMfile(fileNameout, newPic);
		
		newPic = func.controlGrid(gridXY, disgridXY, picLena);
		fileNameout = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\4lenaAfter.pgm";
		func.writePGMfile(fileNameout, newPic);
	}
}