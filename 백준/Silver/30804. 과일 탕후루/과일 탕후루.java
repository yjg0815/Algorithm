import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int max = 0;
        int left = 0;
        HashMap<Integer, Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < n; right++) {
            fruitCount.put(arr[right], fruitCount.getOrDefault(arr[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(arr[left], fruitCount.get(arr[left]) - 1);
                if (fruitCount.get(arr[left]) == 0) {
                    fruitCount.remove(arr[left]);
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}