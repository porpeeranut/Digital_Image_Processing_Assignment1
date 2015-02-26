public class main_3 {
	
	public static void main(String[] args) {
        String fileR, fileG, fileB;
		fileB = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\SanFranPeak_blue.pgm";
		fileG = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\SanFranPeak_green.pgm";
		fileR = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\SanFranPeak_red.pgm";
		int[][] picB = func.getPGMdata(fileB);
		int[][] picR = func.getPGMdata(fileR);
		int[][] picG = func.getPGMdata(fileG);
		int[] histR = func.getHistogram(picR);
		int[] histG = func.getHistogram(picG);
		int[] histB = func.getHistogram(picB);
		func.showGraph(histB, "SanFranPeak_blue");
		func.showGraph(histG, "SanFranPeak_green");
		func.showGraph(histR, "SanFranPeak_red");
		
		int[][] picExcessGreen = new int[picB.length][picB[0].length];
		int[][] picRedBlueDiff = new int[picB.length][picB[0].length];
		int[][] picIntensity = new int[picB.length][picB[0].length];
		int[][] picExcessRed = new int[picB.length][picB[0].length];
		//---------------------------------------------------------------
		for (int row = 0; row < picB.length; row++) {
	        for (int col = 0; col < picB[0].length; col++) {
	        	int val = 2*picG[row][col] - picR[row][col] - picB[row][col];
	        	if (val < 0)
	        		val = 0;
	        	if (val > 255)
	        		val = 255;
	        	picExcessGreen[row][col] = val;
	        }
	    }
		//---------------------------------------------------------------
		for (int row = 0; row < picB.length; row++) {
	        for (int col = 0; col < picB[0].length; col++) {
	        	int val = picR[row][col] - picB[row][col];
				if (val < 0)
					val = 0;
				if (val > 255)
					val = 255;
				picRedBlueDiff[row][col] = val;
	        }
	    }
		//---------------------------------------------------------------
		for (int row = 0; row < picB.length; row++) {
	        for (int col = 0; col < picB[0].length; col++) {
	        	int val = (picR[row][col] + picB[row][col] + picG[row][col])/3;
				if (val < 0)
					val = 0;
				if (val > 255)
					val = 255;
				picIntensity[row][col] = val;
	        }
	    }
		//---------------------------------------------------------------
		for (int row = 0; row < picB.length; row++) {
	        for (int col = 0; col < picB[0].length; col++) {
	        	int val = 2*picR[row][col] - picG[row][col] - picB[row][col];
	        	if (val < 0)
	        		val = 0;
	        	if (val > 255)
	        		val = 255;
	        	picExcessRed[row][col] = val;
	        }
	    }
		//---------------------------------------------------------------
		String fileExcessGreen = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\3ExcessGreen.pgm";
		String fileRedBlueDiff = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\3RedBlueDiff.pgm";
		String fileIntensity = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\3Intensity.pgm";
		String fileExcessRed = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\3ExcessRed.pgm";
		func.writePGMfile(fileExcessGreen, picExcessGreen);
		func.writePGMfile(fileRedBlueDiff, picRedBlueDiff);
		func.writePGMfile(fileIntensity, picIntensity);
		func.writePGMfile(fileExcessRed, picExcessRed);
	}
}