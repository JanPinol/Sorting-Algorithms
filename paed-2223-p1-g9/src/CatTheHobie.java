import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CatTheHobie {
    public static final String ASK_FILE_NAME = "File name: ";
    public static final String END_FILENAME = ".txt";
    //ERRORS
    public static final String ERROR_FILE_NOT_FOUND = "An error occurred.";

    private final ArrayList<Ship> list;

    public CatTheHobie() {
        this.list = new ArrayList<>();
    }

    /**
     *     Embarcacions en funció de l’antiguitat
     *     En aquest cas, es tracta d’ordenar els vaixells del més nou al més antic. L’antiguitat d’un vaixell depèn de
     *     l’ID de forma que com més petit sigui el nombre, més antic serà el vaixell.
     */
    public void quickSort() {
        quickSort(list, 0, list.size() - 1);
        Collections.reverse(list);
    }

    private void quickSort(ArrayList<Ship> list, int left, int right) {
        int p = list.get(left).getId();
        int l = left, r = right;

        while (l < r) {
            while (list.get(l).getId() <= p && l < r) {
                l++;
            }
            while (list.get(r).getId() > p) {
                r--;
            }
            if (l < r) {
                Collections.swap(list, l, r);
            }
        }
        list.get(left).setId(list.get(r).getId());
        list.get(r).setId(p);
        if (left < r-1) {
            quickSort(list, left, r - 1);
        }
        if (r + 1 < right) {
            quickSort(list, r + 1, right);
        }
    }

    /**
     * Embarcacions en funció del nom
     * Per a trobar més fàcilment un vaixell, s’haurà de mostrar un llistat ordenat alfabèticament (de la A a la Z)
     * segons el nom de totes les embarcacions del sistema.
     */
    public void mergeSort() {
        mergeSort(list);
    }

    private void mergeSort(ArrayList<Ship> list) {
        int inputLength = list.size();

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        ArrayList<Ship> leftHalf = new ArrayList<>();
        ArrayList<Ship> rightHalf = new ArrayList<>();

        for (int i = 0; i < midIndex; i++) {
            leftHalf.add(i, list.get(i));
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf.add(i - midIndex, list.get(i));
        }
        mergeSort(leftHalf);
        mergeSort(rightHalf);


        merge(list, leftHalf, rightHalf);

    }

    private void merge (ArrayList<Ship> list, ArrayList<Ship> leftHalf, ArrayList<Ship> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf.get(i).getNom().compareTo(rightHalf.get(j).getNom()) <= 0) {
                list.remove(k);
                list.add(k, leftHalf.get(i));
                i++;
            }
            else {
                list.remove(k);
                list.add(k, rightHalf.get(j));
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            list.remove(k);
            list.add(k, leftHalf.get(i));
            i++;
            k++;
        }
        while (j < rightSize) {
            list.remove(k);
            list.add(k, rightHalf.get(j));
            j++;
            k++;
        }
    }

    /**
     * Embarcacions en funció de les prestacions
     * Com que per a avaluar la qualitat competitiva d’un vaixell no és prou amb tenir en compte la velocitat,
     * ens han demanat ordenar-los combinant una sèrie d’atributs. S’haurà de combinar el pes, l’eslora, la
     * capacitat i la velocitat màxima per tal d’obtenir un criteri fiable. Per exemple, un vaixell lleuger i
     * considerablement ràpid però amb una mida prou gran com per que hi càpiguen 3 persones podria ser
     * més interessant que el vaixell més ràpid però on només hi ha lloc per 1 persona.
     */
    public void bucketSort() {
        bucketSort(list.size());
        Collections.reverse(list);
    }

    public void bucketSort(int n) {
        if (n <= 0) {
            return;
        }

        ArrayList<Ship>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Ship>();
        }

        for (int i = 0; i < n; i++) {
            float bucketIndex = getQualitatCompetitiva(list, i) * n;
            buckets[(int)bucketIndex].add(list.get(i));
        }

        for (int i = 0; i < n; i++) {
            mergeSortBucket(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = buckets[i].size(); j < size; j++) {
                list.remove(index);
                list.add(index++, buckets[i].get(j));
            }
        }
    }

    public void mergeSortBucket(ArrayList<Ship> bucket) {
        int inputLength = bucket.size();

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        ArrayList<Ship> leftHalf = new ArrayList<>();
        ArrayList<Ship> rightHalf = new ArrayList<>();

        for (int i = 0; i < midIndex; i++) {
            leftHalf.add(i, bucket.get(i));
        }
        for (int i = midIndex; i < inputLength; i++) {
            rightHalf.add(i - midIndex, bucket.get(i));
        }
        mergeSortBucket(leftHalf);
        mergeSortBucket(rightHalf);


        mergeBucket(bucket, leftHalf, rightHalf);
    }

    private void mergeBucket (ArrayList<Ship> bucket, ArrayList<Ship> leftHalf, ArrayList<Ship> rightHalf) {
        int leftSize = leftHalf.size();
        int rightSize = rightHalf.size();

        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (getQualitatCompetitiva(leftHalf, i) <= getQualitatCompetitiva(rightHalf, j)) {
                bucket.remove(k);
                bucket.add(k, leftHalf.get(i));
                i++;
            }
            else {
                bucket.remove(k);
                bucket.add(k, rightHalf.get(j));
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            bucket.remove(k);
            bucket.add(k, leftHalf.get(i));
            i++;
            k++;
        }
        while (j < rightSize) {
            bucket.remove(k);
            bucket.add(k, rightHalf.get(j));
            j++;
            k++;
        }
    }

    public float getQualitatCompetitiva(ArrayList<Ship> arrList, int i) {

        return (arrList.get(i).getVelocitat() * 10 +
                arrList.get(i).getEslora() * 10 +
                arrList.get(i).getCapacitat() * 10 +
                arrList.get(i).getPes())/1000;
    }

    public void usageFile() {
        System.out.print(ASK_FILE_NAME);
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();

        try {
            File myObj = new File(filename + END_FILENAME);
            Scanner myReader = new Scanner(myObj);

            String auxNVaixells = myReader.nextLine();
            int nShips = Integer.parseInt(auxNVaixells);

            for (int i = 0; i < nShips; i++) {
                String data = myReader.nextLine();
                saveData(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(ERROR_FILE_NOT_FOUND);
        }
    }

    public void usageFile(String filename) {

        try {
            File myObj = new File(filename + END_FILENAME);
            Scanner myReader = new Scanner(myObj);

            String auxNVaixells = myReader.nextLine();
            int nShips = Integer.parseInt(auxNVaixells);

            for (int i = 0; i < nShips; i++) {
                String data = myReader.nextLine();
                saveData(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(ERROR_FILE_NOT_FOUND);
        }
    }

    private void saveData(String data) {
        String[] parts = data.split(";");

        int id = Integer.parseInt(parts[0]);
        String nom = parts[1];
        String tipus = parts[2];
        float pes = Float.parseFloat(parts[3]);
        float eslora = Float.parseFloat(parts[4]);
        int capacitat = Integer.parseInt(parts[5]);
        int n_competicions = Integer.parseInt(parts[6]);
        String estat = parts[7];
        int velocitat = Integer.parseInt(parts[8]);
        String centre = parts[9];

        Ship ship = new Ship(id, nom, tipus, pes, eslora, capacitat, n_competicions, estat, velocitat, centre);

        list.add(ship);
    }

    private void printarDadesQuickSort(ArrayList<Ship> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId());
        }
    }
    public void printarDadesQuickSort() {
        printarDadesQuickSort(list);
    }

    private void printarDadesMergeSort(ArrayList<Ship> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNom());
        }
    }

    public void printarDadesMergeSort() {
        printarDadesMergeSort(list);
    }

    private void printarDadesBucketSort(ArrayList<Ship> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNom() + "--" + getQualitatCompetitiva(list, i));
        }
    }

    public void printarDadesBucketSort() {
        printarDadesBucketSort(list);
    }
}
