package StacksQueuesProjects;

import java.util.Queue;
import java.util.LinkedList;

//Write a Primes program that finds prime numbers using the Sieve of Eratosthenes
//an algorithm devised by a Greek mathematician of the same name who lived in the third century BC. 
//The algorithm finds all prime numbers up to some maximum value n

public class Project2 {
    public static void main(String[] args) {
        Queue<Integer> example = findPrimes(100);
        System.out.println(example);
    }

    public static Queue<Integer> findPrimes(int n) {
        Queue<Integer> numbers = new LinkedList<Integer>();
        for (int i = 2; i <= n; i++)
            numbers.add(i);
        Queue<Integer> result = new LinkedList<Integer>();

        int p = 1;
        while (p < Math.sqrt(n)) {
            p = numbers.remove();
            result.add(p);
            int size = numbers.size();
            for (int i = 0; i < size; i++) {
                int divisible = numbers.remove();
                if (divisible % p != 0 || divisible == p)
                    numbers.add(divisible);
            }
        }

        while (!numbers.isEmpty())
            result.add(numbers.remove());

        return result;
    }
}
