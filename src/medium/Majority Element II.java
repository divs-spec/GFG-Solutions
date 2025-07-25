class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        // Code here
        Map<Integer,Integer> hm = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0) + 1);
        }
        
        ArrayList<Integer> ls = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            if(e.getValue() > (arr.length/3)){
                int x = e.getKey();
                ls.add(x);
            }
        }
        Collections.sort(ls);
        return ls;
    }
}
