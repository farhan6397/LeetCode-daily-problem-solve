import java.util.Map;
import java.util.TreeMap;

// The class MyCalendar is designed to store bookings as intervals.
// It uses a TreeMap to keep the intervals sorted by start time.
class MyCalendar {

    // Using TreeMap to maintain the intervals sorted by the start key.
    private final TreeMap<Integer, Integer> calendar;

    // Constructor initializes the TreeMap.
    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    /**
     * Tries to book an interval from start to end.
     * @param start the starting time of the interval
     * @param end the ending time of the interval
     * @return true if the booking does not conflict with existing bookings, false otherwise
     */
    public boolean book(int start, int end) {
        // Retrieves the maximum entry whose key is less than or equal to start.
        Map.Entry<Integer, Integer> floorEntry = calendar.floorEntry(start);
      
        // If there is an overlap with the previous interval, return false.
        if (floorEntry != null && floorEntry.getValue() > start) {
            return false;
        }
      
        // Retrieves the minimum entry whose key is greater than or equal to start.
        Map.Entry<Integer, Integer> ceilingEntry = calendar.ceilingEntry(start);
      
        // If there is an overlap with the next interval, return false.
        if (ceilingEntry != null && ceilingEntry.getKey() < end) {
            return false;
        }
      
        // If there is no overlap, add the interval to the TreeMap and return true.
        calendar.put(start, end);
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */