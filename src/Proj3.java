import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Proj3 {
    // Sorting Method declarations
    // Merge Sort
    public static <T extends Comparable> void mergeSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        if(left < right){

            int mid = (left + right) / 2;
            //Recursively sort the left half
            mergeSort(a, left, mid);
            //Recursively sort the right half
            mergeSort(a, mid + 1, right);
            //Merge the sorted halves
            merge(a, left, mid, right);
        }
    }

    public static <T extends Comparable> void merge(ArrayList<T> a, int left, int mid, int right) {
        // Finish Me
        //Create temporary array lists for the left and right halves
        ArrayList<T> leftlist = new ArrayList<>(a.subList(left, (mid + 1)));
        ArrayList<T> rightlist = new ArrayList<>(a.subList(mid + 1, right +1));

        int i = 0, j = 0, k = left;

        //Merge the left and right lists bavk into the orgininal list
        while (i < leftlist.size() && j < rightlist.size()) {
            if (leftlist.get(i).compareTo(rightlist.get(j)) <= 0) {
                a.set(k, leftlist.get(i));
                i++;
            }else{
                a.set(k, rightlist.get(j));
                j++;
            }
            k++;
        }
        //Copy any remaining elements of leftList and right lift if there are any left
        while(i < leftlist.size()){
            a.set(k, leftlist.get(i));
            i++;
            k++;
        }
        while(j < rightlist.size()){
            a.set(k, rightlist.get(j));
            j++;
            k++;
        }
    }

    // Quick Sort
    public static <T extends Comparable> void quickSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        if(left < right){
            //partition the array and get the pivot index
            int pivotIndex = partition(a, left, right);
            //recursively call quicksort to the left of the pivot
            quickSort(a, left, pivotIndex - 1);
            //recursively apply quicksort ot the right of the pivot
            quickSort(a, pivotIndex + 1, right);
        }
    }

    public static <T extends Comparable> int partition (ArrayList<T> a, int left, int right) {
        // Finish Me
        // choose the rightmost element as the pivot
        T pivot = a.get(right);
        int i = left -1;

        for (int j = left; j < right; j++) {
            if (a.get(j).compareTo(pivot) <= 0) {
                i++;
                //swap the elements at i and j
                swap(a, i, j);
            }
        }
        //place pivot in the correct position
        swap(a, i + 1, right);
        return i + 1; //return the pivot index
    }



    // Heap Sort
    public static <T extends Comparable> void heapSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        int n = right - left + 1;

        //build max heap
        for (int i = left + (n/2) -1; i>= left; i--){
            heapify(a, i, right);
        }
        //extract elements from the heap one by one
        for(int i = right; i > left; i--){
            //move current root to the end
            swap(a, left, i);
            //heapify the reduced heap
            heapify(a, left, i -1);
        }
    }

    public static <T extends Comparable> void heapify (ArrayList<T> a, int left, int right) {
        // Finish Me
        int largest = left; //Assume root at 'left' is the largest
        int leftChild = 2 * left + 1; //left child index in the heap
        int rightChild = 2 * left + 2; //right child index is in the heap

        //CHeck is the left and right child exist and if they are greater than the current larges
        if (leftChild <= right && a.get(leftChild).compareTo(a.get(largest)) > 0) {
            largest = leftChild;
        }
        if (rightChild <= right && a.get(rightChild).compareTo(a.get(largest)) > 0) {
            largest = rightChild;
        }
        //If the largest element is not the root, swap and continue heapifying
        if (largest != left) {
            swap(a, left, largest);
            heapify(a, largest, right); //Recursively heapify the affected subtree
        }
    }

    // Bubble Sort
    public static <T extends Comparable> int bubbleSort(ArrayList<T> a, int size) {
        // Finish Me
        int swapCount = 0;
        boolean swapped = false;
        //Outer loop: iterates over each element in the list
        for (int i = 0; i < size - 1; i++) {
            swapped  = false;

            //inner loop: compares adjacent elements
            for (int j = 1; j < size - i; j++){
                if (a.get(j-1).compareTo(a.get(j)) > 0){
                    //swap elements if they are in the wrong order
                    swap(a, j-1,j);
                    swapCount++; //Increment swap count
                    swapped = true;
                }
            }
            //If no elements were swapped during the pass, the list is sorted
            if (!swapped){
                break;
            }
        }
        return swapCount;
    }

    static <T> void swap(ArrayList<T> a, int i, int j) {
        T temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    // Odd-Even Transposition Sort
    public static <T extends Comparable> int transpositionSort(ArrayList<T> a, int size) {
        // Finish Me
        int swapCount = 0;
        boolean isSorted;

        //continue sorting until no swaps are made in both phases
        do{
            isSorted = true; //initially assume the array is sorted
            //odd phase: Compare and swap the
            for (int i = 1; i < size -1; i += 2){
                if (a.get(i).compareTo(a.get(i+1)) > 0){
                    swap(a, i, i+1);
                    swapCount++;
                    isSorted = false; // If a swap is made, the array is not sorted
                }
            }
            //Even phase: compare and swap elements at even indices
            for (int i = 0; i < size -1; i +=2){
                if (a.get(i).compareTo(a.get(i+1)) > 0){
                    swap(a, i, i+1);
                }
            }
        } while(!isSorted); // Reapeat until no swaps are made (array is sorted)
        return swapCount;
    }

    public static void main(String [] args)  throws IOException {
        //...
        //Command line arguments 1)filename 2) the sorting algorithm type to be executed (bubble, merge, quick, heap, transposition) and 3) the number of lines of your dataset to read.
        if(args.length != 3){
            System.out.println("Usage: java Main <filename> <algorithm> <number of lines>");
            return;
        }
        String inputFilename = args [0]; //filename of the dataset
        String algorithm = args[1]; //Sorting algorithm type
        int numLines = Integer.parseInt(args[2]); // number of lines to read in the data set

        //For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        //Open the file input
        inputFileNameStream = new FileInputStream(inputFilename);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        //Ignore the first line
        inputFileNameScanner.nextLine();
        // ...
        //create an array list to store the RealEstateData
        ArrayList<RealEstateData> dataList = new ArrayList<RealEstateData>();
        //Finish Me...
        //Read the file line by line and store the data line by line.
        for(int i = 0; i < numLines && inputFileNameScanner.hasNextLine(); i++) {
            String line = inputFileNameScanner.nextLine().trim();//trims away any data
            if (line.isEmpty()) continue;// skip the empty lines
            String[] parts = line.split(",");
            //create a new RealEstateData object
            try {
                if (parts.length < 16) { //if there is faulty data still continue
                    continue;
                }
                //store the data
                RealEstateData data = new RealEstateData(
                        Integer.parseInt(parts[0]), //ID
                        parts[1], //PossesionStatus
                        parts[2], // Commercial
                        parts[3], //Developer
                        Integer.parseInt(parts[4]), //price
                        Integer.parseInt(parts[5]), //sqftprice
                        parts[6],//furnished
                        Integer.parseInt(parts[7]), //bathroom
                        parts[8], //direction facing
                        parts[9], //transaction
                        parts[10], //type
                        parts[11], //city
                        Integer.parseInt(parts[12]), // bedrooms
                        Integer.parseInt(parts[13]), //floors
                        parts[14], //isprimelocation
                        parts[15]); // lifespan
                //add data to the Array
                dataList.add(data);
                //Catch statement showing what lines might contain faulty data, skip and continue with insertion / search
            }catch (NumberFormatException e) {
                System.err.println("Error parsing line: " + line);
            }
        }
        inputFileNameScanner.close();

        //Print the data before sorting
        System.out.println("Dataset before performing operations: ");
        for (RealEstateData data : dataList) {
            System.out.println(data);
        }

        //Execute the chosen sorting analysis
        int swapCount = 0;
        switch(algorithm.toLowerCase()){
            case "bubble":
                //Calculate the Bubble sort run time for sorted, shuffled, and reversed data sets
                //count number of comparisons for bubble

                //sort the data
                Collections.sort(dataList);
                //time the sorting process
                long startTime = System.nanoTime();
                swapCount = bubbleSort(dataList, dataList.size());
                long endTime = System.nanoTime();
                long Runtime = endTime - startTime;
                System.out.println("Sorted data Bubble sort run time: " + Runtime);
                System.out.println("Number of comparisons: " + swapCount);

                //shuffled data set
                Collections.shuffle(dataList);
                startTime = System.nanoTime();
                swapCount = bubbleSort(dataList, dataList.size());
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Shuffled data Bubble sort run time: " + Runtime);
                System.out.println("Number of comparisons: " + swapCount);

                //Reversed data set
                Collections.reverse(dataList);
                startTime = System.nanoTime();
                swapCount = bubbleSort(dataList, dataList.size());
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Reversed data Bubble sort run time: " + Runtime);
                System.out.println("Number of comparisons: " + swapCount);
                break;

            case "transposition":
                //Calculate the odd even sort run time for sorted, shuffled, and reversed data sets
                //count number of comparisons for heap

                //sort the data
                Collections.sort(dataList);
                //time the sorting process
                startTime = System.nanoTime();
                swapCount = transpositionSort(dataList, dataList.size());
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Sorted data transposition sort run time: " + Runtime);
                System.out.println("Number of comparisons: " + swapCount);

                //shuffled data set
                Collections.shuffle(dataList);
                startTime = System.nanoTime();
                swapCount = transpositionSort(dataList, dataList.size());
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Shuffled data transposition sort run time: " + Runtime);
                System.out.println("Number of comparisons: " + swapCount);

                //Reversed data set
                Collections.reverse(dataList);
                startTime = System.nanoTime();
                swapCount = transpositionSort(dataList, dataList.size());
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Reversed data Bubble sort run time: " + Runtime);
                System.out.println("Number of comparisons: " + swapCount);
                break;
            case "merge":
                //Calculate the Merge sort run time for sorted, shuffled, and reversed data sets

                //sort the data
                Collections.sort(dataList);
                //time the sorting process
                startTime = System.nanoTime();
                mergeSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Sorted data Merge sort run time: " + Runtime);

                //shuffled data set
                Collections.shuffle(dataList);
                startTime = System.nanoTime();
                mergeSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Shuffled data Merge sort run time: " + Runtime);

                //Reversed data set
                Collections.reverse(dataList);
                startTime = System.nanoTime();
                mergeSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Reversed data Merge sort run time: " + Runtime);
                break;
            case "quick":
                //Calculate the Quick sort run time for sorted, shuffled, and reversed data sets

                //sort the data
                Collections.sort(dataList);
                //time the sorting process
                startTime = System.nanoTime();
                quickSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Sorted data Quick sort run time: " + Runtime);

                //shuffled data set
                Collections.shuffle(dataList);
                startTime = System.nanoTime();
                quickSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Shuffled data Quick sort run time: " + Runtime);

                //Reversed data set
                Collections.reverse(dataList);
                startTime = System.nanoTime();
                quickSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Reversed data Quick sort run time: " + Runtime);
                break;
            case "heap":
                //Calculate the Heap sort run time for sorted, shuffled, and reversed data sets

                //sort the data
                Collections.sort(dataList);
                //time the sorting process
                startTime = System.nanoTime();
                heapSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Sorted data Heap sort run time: " + Runtime);

                //shuffled data set
                Collections.shuffle(dataList);
                startTime = System.nanoTime();
                heapSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Shuffled data Heap sort run time: " + Runtime);

                //Reversed data set
                Collections.reverse(dataList);
                startTime = System.nanoTime();
                heapSort(dataList,0,dataList.size()-1);
                endTime = System.nanoTime();
                Runtime = endTime - startTime;
                System.out.println("Reversed data Heap sort run time: " + Runtime);
                break;
        }



    }
}
