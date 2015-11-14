public boolean switchable(TreeNode rootA, TreeNode rootB){
	if(rootA.val != rootB.val){
		return false;
	}
	TreeNode Aleft = rootA.left;
	TreeNode Aright = rootA.right;
	TreeNode Bleft = rootB.left;
	TreeNode Bright = rootB.right;
	boolean leftMatch = (Aleft == null && Bleft == null) || (Aleft != null && Bleft != null && Aleft.val == Bleft.val);		// see if left nodes match
	boolean rightMatch = (Aright == null && Bright == null) || (Arightt != null && Bright != null && Aright.val == Bright.val);	// see if right nodes match
	if(leftMatch && rightMatch){	//they match, so compare against NULL cases
		if(Aleft != null && Aright != null)
			return (switchable(Aleft, Bleft) && isSame(Aright, Bright))||(switchable(Aright, Bright) && isSame(Aleft, Bleft));	//could only switch one pair
		else if(Aleft != null && Aright == null)
			return switchable(Aleft, Bleft);
		else if(Aleft == null && Aright != null)
			return switchable(Aright, Bright);
		else
			return true;
	}
	else{	//they don't match, see if they are symmetrical
		if((Aleft == null && Bright != null) || (Aleft != null && Bright == null)|| (Aright == null && Bleft != null) || (Aright != null && Bleft == null))
			return false;	//check when NULL nodes exist
		if((Aleft.val != Bright.val) || (Aright.val != Bleft.val))
			return false;	// now check when all nodes all not NULL
		return isSame(Aleft, Bright) && isSame(Aright, Bleft);	//they are symmetric, so just compare if trees are same
	}
}

public boolean isSame(TreeNode rootA, TreeNode rootB){
	....
}