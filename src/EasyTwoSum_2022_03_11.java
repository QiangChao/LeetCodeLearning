import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EasyTwoSum_2022_03_11 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                index[0] = i;
                index[1] = map.get(nums[i]);
                break;
            }
            map.put(target - nums[i], i);
        }
        return index;
    }
}
