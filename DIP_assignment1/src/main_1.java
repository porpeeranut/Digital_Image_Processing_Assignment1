public class main_1 {

	public static void main(String[] args) {
		String fileName;
		fileName = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\scaled_shapes.pgm";
		int[][] pic = func.getPGMdata(fileName);
		int[] Histogram = func.getHistogramAndPrintGrayLV(pic, 100);
		
		func.showGraph(Histogram, "scaled_shapes");
		
		//	get grayLV each obj
		int[] grayLVeachObj = new int[6];
		int j = 0, threshold = 100;
		for (int i = 0; i < Histogram.length; i++) {
        	if (Histogram[i] > threshold)
        		grayLVeachObj[j++] = i; 
        }
		
		//	loop each obj
		for (int i = 0; i < grayLVeachObj.length; i++) {
			String fileNameout = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\1scaled_shapes"+i+".pgm";
			func.writePGMfile(fileNameout, func.getBW0255_imageFromGrayLVThreshold(pic, grayLVeachObj[i]));
			int[][] pic01_lv0 = func.getBW01_imageFromGrayLVThreshold(pic, grayLVeachObj[i]);
			double m00 = func.getMomentFromBW01(pic01_lv0, 0, 0);
			double m10 = func.getMomentFromBW01(pic01_lv0, 1, 0);
			double m01 = func.getMomentFromBW01(pic01_lv0, 0, 1);
			double x = m10/m00;
			double y = m01/m00;
			
			double n20 = func.getNormalizedMomentFromBW01(pic01_lv0, 2, 0, x, y);
			double n02 = func.getNormalizedMomentFromBW01(pic01_lv0, 0, 2, x, y);
			double quantity = n20+n02;
			System.out.println("x "+x+", y "+y+", quantity "+quantity);
			System.out.println();
        }
	}
}