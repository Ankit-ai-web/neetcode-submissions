
class TimeMap {

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        ArrayList<Pair> list = map.get(key);

        int low = 0, high = list.size() - 1;
        String res = "";

        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid).time == timestamp) {
                return list.get(mid).val;
            } 
            else if (list.get(mid).time < timestamp) {
                res = list.get(mid).val; // possible answer
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return res;
    }

    class Pair {
        int time;
        String val;

        Pair(int t, String v) {
            time = t;
            val = v;
        }
    }
}