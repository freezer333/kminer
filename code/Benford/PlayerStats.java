package Benford;
import java.util.*; 
class PlayerStats {
    private String player;
    private List<Integer> stats;
    private int total;
    
    public PlayerStats (String player, int stat) {
        this.player = player;
        this.stats = new ArrayList<Integer>();
        this.stats.add(stat);
        this.total = stat;
    }
    
    public void record(int stat) {
        this.stats.add(stat);
        this.total += stat;
    }
    
    public int getTotal() {
        return this.total;
    }
}
