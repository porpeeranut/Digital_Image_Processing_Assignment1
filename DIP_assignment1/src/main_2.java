public class main_2 {

	public static void main(String[] args) {
        String fileName1, fileName2;
		fileName1 = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\Cameraman.pgm";
		fileName2 = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\SEM256_256.pgm";
		int[][] pic1 = func.getPGMdata(fileName1);
		int[][] pic2 = func.getPGMdata(fileName2);
		int[] Histogram1 = func.getHistogram(pic1);
		int[] Histogram2 = func.getHistogram(pic2);
		func.showGraph(Histogram1, "Cameraman");
		func.showGraph(Histogram2, "SEM256_256");
		
		double area = pic1.length*pic1[0].length;
		pic1 = func.histogramEqualize(Histogram1, area, pic1);
		String fileNameout = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\2Cameraman.pgm";
		func.writePGMfile(fileNameout, pic1);
		Histogram1 = func.getHistogram(pic1);
		func.showGraph(Histogram1, "Cameraman equalize");
		
		area = pic2.length*pic2[0].length;
		pic2 = func.histogramEqualize(Histogram2, area, pic2);
		fileNameout = "D:\\Google Drive\\CMU\\3rd\\semester 2\\261453 Digital Image Processing\\HW2\\2SEM256_256.pgm";
		func.writePGMfile(fileNameout, pic2);
		Histogram2 = func.getHistogram(pic2);
		func.showGraph(Histogram2, "SEM256_256 equalize");
	}
}