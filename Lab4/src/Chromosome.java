import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chromosome {

    private int nodeNr;
    private List<Integer> generare;
    private Matrix matrice;
    private int fitness;


    public Chromosome(Matrix matrice)
    {
        this.matrice = matrice;

        this.nodeNr = matrice.getSize();

        this.generare = new ArrayList<>(matrice.getNoduri());

        Collections.shuffle(generare);

        this.fitness = calculateFitness();
    }


    public int calculateFitness(){

        return this.matrice.pathLength(generare);
    }

    public Chromosome crossOver(Chromosome other){

        List<Integer> xo = new ArrayList<>(nodeNr);

        for(int i = 0; i< nodeNr; i++) {
            xo.add(other.generare.get(this.generare.get(i) - 1));
        }

        Chromosome offspringz = new Chromosome(this.matrice);
        offspringz.setGenerare(xo);
        offspringz.setFitness(offspringz.calculateFitness());

        return offspringz;
    }

    public Chromosome mutation(){

        int poz1 = (int)(Math.random()*(nodeNr -1)) ;
        int poz2 = (int)(Math.random()*(nodeNr -1)) ;
        Integer aux = generare.get(poz1);
        this.generare.set(poz1, generare.get(poz2));
        this.generare.set(poz2,aux);

        return this;
    }

    public List<Integer> getGenerare() {
        return generare;
    }

    public void setGenerare(List<Integer> generare) {
        this.generare = generare;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }
}
