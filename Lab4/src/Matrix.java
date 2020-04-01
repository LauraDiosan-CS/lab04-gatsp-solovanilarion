import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private int[][] adjMatrice;
    private List<Integer> noduri;
    private int size;


    public void initialize(String filen){

        try(BufferedReader br = new BufferedReader(new FileReader(filen))) {
            String string = br.readLine();
            int n = Integer.parseInt(string);
            if(adjMatrice == null){
                this.size = n;
                adjMatrice = new int[n][n];
            }
            noduri = new ArrayList<>(size);
            for(int i=0;i<n;i++){
                noduri.add(i+1);
                String[] costs = br.readLine().split(",");

                for(int j=0;j<n;j++) {
                    if (i == j) {
                        adjMatrice[i][j] = 0;
                    } else {

                        adjMatrice[i][j] = Integer.parseInt(costs[j]);
                    }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public Integer pathLength(List<Integer> path){

        int length = 0;
        for(int i =0;i< path.size()-1;i++){

            length += adjMatrice[path.get(i)-1][path.get(i+1)-1];
        }
        //length += adjMatrice[path.get(path.size()-1)-1][path.get(0)-1];

        return length;
    }

    public List<Integer> getNoduri() {
        return noduri;
    }

    public int getSize() {
        return size;
    }


}
