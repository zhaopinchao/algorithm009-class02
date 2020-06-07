学习笔记

```
泛型递归模板

def recursion(level, param1, param2, ……) {
	# recursion terminator
	if(level > max_level) {
			process_result
			return
	}
	
	# process logic in current level
	process(level, data……)
	
	# drill down
	self.recursion(level + 1, p1, ……)
	
	# reverse the current level status if needed
}

分治、回溯模板
def divide_conquer(problem, param1, param2, ……){
	# resursion terminator
	if problem is None:
		print_result
		result
	# prepare data
	data = prepare_data(problem)
	subproblems = split_problem(problem, data)
	
	# coonquer subproblems
	subresult1 = self.divide_conquer(subproblems[0], p1, ……)
	subresult2 = self.divide_conquer(subproblems[1], p1, ……)
	subresult3 = self.divide_conquer(subproblems[2], p1, ……)
	……
	
	# process and generate the final result
	result = process_result(subresult1, subresult2, subresult3, ……)
	# revert the current level state
}
```

分治、回溯都是递归的一种， 所有的递归的本质上都是：**找重复性，拆分子问题，合并子问题结果**




