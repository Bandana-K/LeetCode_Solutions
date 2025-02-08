class NumberContainers {

    Map<Integer, Integer> indexNumMap;
    Map<Integer, TreeSet<Integer>> numberIndexMap;
    public NumberContainers() {
        indexNumMap = new HashMap<>();
        numberIndexMap = new HashMap<>();
    }
    
    public void change(int index, int number) {

        if(indexNumMap.containsKey(index)){
            var prevNumberAtIndex = indexNumMap.get(index);

            if(numberIndexMap.get(prevNumberAtIndex).size() == 1)
                numberIndexMap.remove(prevNumberAtIndex);
            else
                numberIndexMap.get(prevNumberAtIndex).remove(index);
        }

        numberIndexMap.putIfAbsent(number, new TreeSet<>());
        numberIndexMap.get(number).add(index);

        indexNumMap.put(index, number);
    }
    
    public int find(int number) {
        if(numberIndexMap.containsKey(number)) return numberIndexMap.get(number).first();
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */