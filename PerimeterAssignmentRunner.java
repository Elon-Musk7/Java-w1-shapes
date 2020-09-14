import edu.duke.*;
import java.io.File;


public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int iNum = 0;
        for (Point Pt : s.getPoints()){
            iNum += 1;
        }
        return iNum;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avgL;
        int i = getNumPoints(s);
        double p = getPerimeter(s);
        avgL = p/i;
        return avgL;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double cL, Lside = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point Pt : s.getPoints()) {
            cL = prevPt.distance(Pt);
            if (Lside < cL) {
                Lside = cL;
            }
            prevPt = Pt;
        }
        return Lside;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double x, Lx = 0.0;
        for (Point Pt : s.getPoints()) {
            x = Pt.getX();
            if (Lx < x) {
                Lx = x;
            }
        }
        return Lx;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double cP, Lp = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr=new FileResource(f);
            Shape s = new Shape(fr);
            cP = getPerimeter(s);
            if (Lp < cP) {
                Lp = cP;
            }
        }
        return Lp;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        double cP, Lp = 0.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr=new FileResource(f);
            Shape s = new Shape(fr);
            cP = getPerimeter(s);
            if (Lp < cP) {
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("example1.txt");
        Shape s = new Shape(fr);
        int iNum = getNumPoints(s);
        System.out.println("num of Points = " + iNum);
        double avgL = getAverageLength(s);
        System.out.println("avgL2 = " + avgL);
        double Lside = getLargestSide(s);
        System.out.println("Lside = " + Lside);
        double Lx = getLargestX(s);
        System.out.println("Lx = " + Lx);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double Lp = getLargestPerimeterMultipleFiles();
        System.out.println("Lp multiple files = " + Lp);
        String fn = getFileWithLargestPerimeter();
        System.out.println("file name with Lp in multiple files = " + fn);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
