import java.util.ArrayList;
import java.util.List;

public class Populatie {

    private List<Chromosome> populatie;
    private Integer populSize;

    public Populatie(Integer populSize, Matrix matrix){

        this.populatie = new ArrayList<>(populSize);
        this.populSize = populSize;

        for(int i = 0; i<this.populSize; i++){
            populatie.add(new Chromosome(matrix));
        }
    }

    public Populatie(Populatie populatie){
        this.populatie = populatie.populatie;
        this.populSize = populatie.populSize;
    }

    public Chromosome selection(){

        Chromosome firstSelection = populatie.get((int)(Math.random()* populSize -1));
        Chromosome secondSelection = populatie.get((int)(Math.random()* populSize -1));

        if (firstSelection.getFitness() < secondSelection.getFitness()){
            return firstSelection;
        }
        else {
            return secondSelection;
        }
    }

    public Chromosome getTheBest(){

        Chromosome zaBest = populatie.get(0);
        for(Chromosome ch : populatie){
            if (ch.getFitness() < zaBest.getFitness())
                zaBest = ch;
        }
        return zaBest;
    }

    public void addGeneration(Chromosome generation){

        populatie.add(generation);
        populSize += 1;
    }
}
