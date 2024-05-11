import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class SetPerformanceTest {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        Random random = new Random();

        //  Fill all Sets
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(1000000);
            hashSet.add(value);
            treeSet.add(value);
            linkedHashSet.add(value);
        }

        // Measure time for add operation
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            hashSet.add(value);
        }
        long hashSetAddTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            treeSet.add(value);
        }
        long treeSetAddTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            linkedHashSet.add(value);
        }
        long linkedHashSetAddTime = System.nanoTime() - startTime;

        // Measure time for remove operation
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            hashSet.remove(value);
        }
        long hashSetRemoveTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            treeSet.remove(value);
        }
        long treeSetRemoveTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            linkedHashSet.remove(value);
        }
        long linkedHashSetRemoveTime = System.nanoTime() - startTime;

        //  Measure time for search operation
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            hashSet.contains(value);
        }
        long hashSetContainsTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            treeSet.contains(value);
        }
        long treeSetContainsTime = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            int value = random.nextInt(2000000);
            linkedHashSet.contains(value);
        }
        long linkedHashSetContainsTime = System.nanoTime() - startTime;

        System.out.println("HashSet:");
        System.out.println("Add time: " + hashSetAddTime + " nanoseconds");
        System.out.println("Remove time: " + hashSetRemoveTime + " nanoseconds");
        System.out.println("Contains time: " + hashSetContainsTime + " nanoseconds");

        System.out.println("\nTreeSet:");
        System.out.println("Add time: " + treeSetAddTime + " nanoseconds");
        System.out.println("Remove time: " + treeSetRemoveTime + " nanoseconds");
        System.out.println("Contains time: " + treeSetContainsTime + " nanoseconds");

        System.out.println("\nLinkedHashSet:");
        System.out.println("Add time: " + linkedHashSetAddTime + " nanoseconds");
        System.out.println("Remove time: " + linkedHashSetRemoveTime + " nanoseconds");
        System.out.println("Contains time: " + linkedHashSetContainsTime + " nanoseconds");
    }
    //The obtained data allows us to conclude that:
//HashSet: is the fastest for adding and searching operations, but not very efficient for removal operation.
//TreeSet: is the slowest for adding operation, but the fastest for removal and searching operations.
//LinkedHashSet: ensures constant time for adding and removing elements, maintains the order of elements.

}
