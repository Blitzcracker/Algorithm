public int minStep(String input){
	int len = input.length();
	char curr[] = new char[len];
	Arrays.fill(curr, 'a');
	
	HashSet<char[]> set = new HashSet<>();
	Queue<char[]> queue = new LinkedList<>();
	queue.offer(curr);
	int count = 1;
	int level = 0;

	while(!queue.isEmpty()){	//do bfs
		curr = queue.poll();
		count--;
		int correct = getResult(curr.toString(), input);	// from the helper
		int wrong = getResult(curr.toString(), input);
		if(correct == len)
			return level;
		for(int i = 0; i < len; ++i){
			char c = curr[i];			
			for(char j = 'a'; j <= 'z'; j++){
				if(c == char)
					continue;
				else{
					curr[i] = j;
					int tmpCorrect = getResult(curr.toString(), input);
					int tmpWrong = getResult(curr.toString(), input);
					if(!set.contains(curr) && (tmpCorrect > correct || (tmpCorrect == corret && tmpWrong >= wrong))){	//if no progress, we should still add it to queue
						queue.offer(curr);
					}
					set.add(curr);	//no matter this result is good or not, we don't visit it twice
				}
			}
		}
		if(count == 0){
			count = queue.size();
			level++;
		}
	}
}