package edu.guilford;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class MovieDriver {
    public static void main(String[] args) {

        // set a new scanner to get user input
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("How many movies do you need? ");
        int movieCount = scan.nextInt();
        // creating an array of movies and filling it with random movies
        Movie[] movies = new Movie[movieCount];
        for (int i = 0; i < movieCount; i++) {
            movies[i] = new Movie();
        }

        // print out the unsorted array of movies
        System.out.println("Unsorted Movies(Round 1): \n");
        // for every Movie object in the array movies, print it out.
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        // Sort movies using bubble sort (O(n^2))
        // method created
        bubbleSortByReleaseYear(movies);
        System.out.println("Movies sorted by release year (Bubble Sort):");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " (" + movie.getYear() + ")");
        }
        long startTimeBubbleSort = System.nanoTime();
        bubbleSortByReleaseYear(movies);
        long endTimeBubbleSort = System.nanoTime();
        long elapsedTimeBubbleSort = endTimeBubbleSort - startTimeBubbleSort;
        System.out.println("Bubble Sort Time: " + elapsedTimeBubbleSort + " nanoseconds");
        System.out.println();

        shuffleArray(movies);
        // print out the unsorted array of movies
        System.out.println("Unsorted Movies: \n" + Arrays.toString(movies));

        // Sort movies using merge sort (O(log n))
        mergeSortByDuration(movies);
        System.out.println("\nMovies sorted by duration time (Merge Sort):");
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " (" + movie.getDurationInMin() + " Min)");
        }
        // Measure time for merge sort
        long startTimeMergeSort = System.nanoTime();
        mergeSortByDuration(movies);
        long endTimeMergeSort = System.nanoTime();
        long elapsedTimeMergeSort = endTimeMergeSort - startTimeMergeSort;
        System.out.println("Merge Sort Time: " + elapsedTimeMergeSort + " nanoseconds");
    }

    // Bubble sort method (O(n^2))
    public static void bubbleSortByReleaseYear(Movie[] movies) {
        int n = movies.length;
        // every time int i is incremented, the last element is sorted
        for (int i = 0; i < n - 1; i++) {
            // for every element in the array, compare it to the next element
            // every time int j is incremented, the next element is sorted
            for (int j = 0; j < n - i - 1; j++) {
                // if the current element is greater than the next element, swap them
                // if the current element is less than the next element, do nothing
                if (movies[j].getYear() > movies[j + 1].getYear()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

    // Merge sort algorithm (O(log n))
    // The merge sort algorithm follows the divide-and-conquer approach. It
    // recursively divides the array into smaller subarrays, sorts them
    // individually, and then merges them back together. This process continues
    // until the array is completely sorted
    public static void mergeSortByDuration(Movie[] movies) {
        // if movies is greater than one, we run this code
        if (movies.length > 1) {
            // mid divides the movie array into 2 sections
            int mid = movies.length / 2;
            // creates two new arrays that will contain the left and right halves of the
            // movies array
            Movie[] leftArray = Arrays.copyOfRange(movies, 0, mid);
            Movie[] rightArray = Arrays.copyOfRange(movies, mid, movies.length);
            // keep repeating the process by recursively sorting the left and right halves
            mergeSortByDuration(leftArray);
            mergeSortByDuration(rightArray);
            // merge the left and right halves together once again after being sorted
            merge(movies, leftArray, rightArray);
        }
    }

    private static void merge(Movie[] movies, Movie[] leftArray, Movie[] rightArray) {

        // set the size of the left and right arrays
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        // set the index of the left, right, and movies arrays to 0
        int i = 0, j = 0, k = 0;
        // while the left index is less than the left size and the right index is less
        // than the right size
        while (i < leftSize && j < rightSize) {
            // if the duration of the movie in the left array is less than or equal to the
            // duration of the movie in the right array
            // set the movie in the movies array to the movie in the left array
            // increment the left index
            if (leftArray[i].getDurationInMin() <= rightArray[j].getDurationInMin()) {
                movies[k++] = leftArray[i++];
                // if the duration of the movie in the left array is greater than the duration
                // of the movie in the right array
                // set the movie in the movies array to the movie in the right array
                // increment the right index
            } else {
                movies[k++] = rightArray[j++];
            }
        }

        // if the left index is less than the left size
        // set the movie in the movies array to the movie in the left array
        // increment the left index
        while (i < leftSize) {
            movies[k++] = leftArray[i++];
        }

        // if the right index is less than the right size
        // set the movie in the movies array to the movie in the right array
        // increment the right index
        while (j < rightSize) {
            movies[k++] = rightArray[j++];
        }
    }

    // Shuffle the array of Movie objects
    public static void shuffleArray(Movie[] movies) {
        Random random = new Random();

        for (int i = movies.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Movie temp = movies[index];
            movies[index] = movies[i];
            movies[i] = temp;
        }
    }
}
