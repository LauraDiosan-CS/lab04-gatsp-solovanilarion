public class Main {

    public static void main(String[] args) {

        Generator graph = new Generator("C:\\Users\\IUSTIN\\Desktop\\Lab4\\src\\files\\medium_01_tsp.txt");
        graph.evolutiveTSP(500,500, "C:\\Users\\IUSTIN\\Desktop\\Lab4\\src\\files\\Slvr_medium");
    }
}
