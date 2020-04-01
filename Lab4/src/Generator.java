import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {

    private Matrix datasets;


    public Generator(String filename){

        datasets = new Matrix();
        datasets.initialize(filename);
    }

    public void evolutiveTSP(Integer popSize, Integer nrStepz, String filen){
        Populatie populatie = new Populatie(popSize, datasets);
        Populatie lastPopulatie = new Populatie(populatie);

        while(nrStepz > 0){
            Populatie newPopulatie = new Populatie(populatie);

            for(int i=0; i< popSize; i++){
                Chromosome male = populatie.selection();
                Chromosome female = populatie.selection();
                Chromosome offspring = male.crossOver(female);
                Chromosome offspringMutant = offspring.mutation();
                newPopulatie.addGeneration(offspringMutant);
            }
            nrStepz--;
            lastPopulatie = new Populatie(newPopulatie);
        }

        Chromosome theBest = lastPopulatie.getTheBest();
        printToFile(theBest , filen);
    }


    public void printToFile(Chromosome x , String filename){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(x.getGenerare().size() + "\n");
            System.out.print("The best solutin: ");
            for(Integer i : x.getGenerare()) {
                System.out.print(i + " ");
                bw.write(i + " ");
            }
            System.out.println();
            System.out.println("The best scor: " + x.getFitness());
            bw.write("\n" + x.getFitness());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
