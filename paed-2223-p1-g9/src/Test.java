public class Test {
    public void testQuickSort() {
        CatTheHobie a = new CatTheHobie();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------");
        System.out.println("QUICKSORT METHOD");
        System.out.println("----------------------------------------------------------");
        a.usageFile();
        System.out.println("----------------------------------------------------------");
        System.out.println("UNSORTED DATA");
        System.out.println("----------------------------------------------------------");
        a.printarDadesQuickSort();
        a.quickSort();
        System.out.println("----------------------------------------------------------");
        System.out.println("SORTED DATA");
        System.out.println("----------------------------------------------------------");
        a.printarDadesQuickSort();

        System.out.println("----------------------------------------------------------");
        System.out.println("TIME ELAPSED QUICKSORT METHOD (ns)");
        System.out.println("----------------------------------------------------------");

        a.usageFile("fleetXS");
        long startTime = System.nanoTime();
        a.quickSort();
        long stopTime = System.nanoTime();
        System.out.print("File fleetXS: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetS");
        startTime = System.nanoTime();
        a.quickSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetS: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetM");
        startTime = System.nanoTime();
        a.quickSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetM: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetL");
        startTime = System.nanoTime();
        a.quickSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetL: ");
        System.out.println(stopTime - startTime);
    }

    public void testMergeSort() {
        CatTheHobie a = new CatTheHobie();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------");
        System.out.println("MERGESORT METHOD");
        System.out.println("----------------------------------------------------------");
        a.usageFile();
        System.out.println("----------------------------------------------------------");
        System.out.println("UNSORTED DATA");
        System.out.println("----------------------------------------------------------");
        a.printarDadesMergeSort();
        a.mergeSort();
        System.out.println("----------------------------------------------------------");
        System.out.println("SORTED DATA");
        System.out.println("----------------------------------------------------------");
        a.printarDadesMergeSort();

        System.out.println("----------------------------------------------------------");
        System.out.println("TIME ELAPSED MERGESORT METHOD (ns)");
        System.out.println("----------------------------------------------------------");

        a.usageFile("fleetXS");
        long startTime = System.nanoTime();
        a.mergeSort();
        long stopTime = System.nanoTime();
        System.out.print("File fleetXS: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetS");
        startTime = System.nanoTime();
        a.mergeSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetS: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetM");
        startTime = System.nanoTime();
        a.mergeSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetM: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetL");
        startTime = System.nanoTime();
        a.mergeSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetL: ");
        System.out.println(stopTime - startTime);
    }

    public void testBucketSort() {
        CatTheHobie a = new CatTheHobie();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------");
        System.out.println("BUCKETSORT METHOD");
        System.out.println("----------------------------------------------------------");
        a.usageFile();
        System.out.println("----------------------------------------------------------");
        System.out.println("UNSORTED DATA");
        System.out.println("----------------------------------------------------------");
        a.printarDadesBucketSort();
        a.bucketSort();
        System.out.println("----------------------------------------------------------");
        System.out.println("SORTED DATA");
        System.out.println("----------------------------------------------------------");
        a.printarDadesBucketSort();

        System.out.println("----------------------------------------------------------");
        System.out.println("TIME ELAPSED BUCKETSORT METHOD (ns)");
        System.out.println("----------------------------------------------------------");

        a.usageFile("fleetXS");
        long startTime = System.nanoTime();
        a.bucketSort();
        long stopTime = System.nanoTime();
        System.out.print("File fleetXS: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetS");
        startTime = System.nanoTime();
        a.bucketSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetS: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetM");
        startTime = System.nanoTime();
        a.bucketSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetM: ");
        System.out.println(stopTime - startTime);

        a.usageFile("fleetL");
        startTime = System.nanoTime();
        a.bucketSort();
        stopTime = System.nanoTime();
        System.out.print("File fleetL: ");
        System.out.println(stopTime - startTime);
    }
}
