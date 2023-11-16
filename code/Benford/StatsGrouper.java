package Benford;

import Benford.PlayerStats;
import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList;
import java.util.List; 

public class StatsGrouper {
    private HashMap<String, PlayerStats> players;
    
    public StatsGrouper () {
        this.players = new HashMap<String, PlayerStats>();
    }
    
    public void record(String player_name, int value) {
        PlayerStats ps = this.players.get(player_name);
        if (ps != null) {
            ps.record(value);
        } else {
            ps =new PlayerStats(player_name, value);
            this.players.put(player_name, ps);
        }
    }
    
    // This returns a list of the career totals.  Use this list like you used games_played... and 
    // you have the distribution for career games played...
    public List<Integer> totals() {
        List<Integer> t = new ArrayList<Integer>();
        for (Map.Entry<String, PlayerStats> item : this.players.entrySet()) { 
            t.add(item.getValue().getTotal());
        } 
        return t;
    }
    
    // This is just for information...
    public void print() {
        for (Map.Entry<String, PlayerStats> item : this.players.entrySet()) { 
            System.out.println(item.getKey() + " => " + item.getValue().getTotal());
        } 
    }
}