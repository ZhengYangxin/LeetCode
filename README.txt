算法练习
参考
https://github.com/617076674/LeetCode

https://leetcode.wang/

https://visualgo.net/zh

重点代码

反转链表
pubic ListNode reverse(ListNode head) {
    ListNode pre = null;
    ListNode cur = head;

    while(cur != null){
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
}


中序遍历  stack

public List<Integer> inorderTraversal(TreeNode root) {

    List<Integer> list = new Arrays<>();
    Stack<TreeNode> stack =new Stack<>();
    TreeNode cur = root;
    while(cur != null || !stack.isEmpty()) {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }

    return list;
}

前序遍历

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();

    stack.add(root);

    while(!stack.isEmpty()) {
        TreeNode node = stack.pop();
        if(node != null) {
            list.add(node.val);
            stack.add(node.right);
            stack.add(node.left);
        }
    }
    return list;
}

后续遍历

public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode last = null;
    while(root != null || !stack.isEmpty()) {
        if(cur != null){
            stack.push(cur);
            cur = cur.left;
        } else{
            TreeNode node = stack.peak();
            if(node.right != null && node.right != last) {
                cur = node.right;
            } else {
                list.add(node.val);
                last = node;
                stack.pop();
            }
        }
    }

}

广度优先遍历

public List<Integer> levelTraversal(Node node) {
    List<Integer> values = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while(!queue.isEmpty()){
        Node node = queue.remove();
        if (node != null) {
             values.add(node.val);
             if (!node.children.isEmpty()) {
                for (Node child: node.children) {
                    values.add(child);
                }
             }
        }
    }
}


广度优先遍历 需要单独记录每一层
// 用LinkList 做队列，需要对元素判空，应为LinkList可以存储空节点
public List<Integer> levelTraversal(Node node) {
    List<List<Integer>> values = new ArrayList<>();
    if（node == null）{
        return values;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while(!queue.isEmpty()){
        int size = queue.size();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < size; i++) {  // batch process
            Node node = queue.remove();
            if (node != null) {
                 ans.add(node.val);
                 //        if (!node.children.isEmpty()) {
                 //            for (Node child: node.children) {
                 //                queue.add(child);
                 //            }
                 //        }
                 if (node.left != null) {
                    queue.add(node.left)
                 }
                 if (node.right != null) {
                     queue.add(node.right)
                  }
            }
        }
        values.add(ans);
    }
    return values;
}



深度优先遍历  递归
public void dfs(TreeNode node , HashSet<TreeNode> visited){
    // terminator
    if(visited.contain(node)){
        return;
    }
    visited.add(node);

    // logic process

    // drill down
    if(node.left != null) dfs(node.left, visited);
    if(node.right != null) dfs(node.right, visited);
}

非递归
public void dfs(TreeNode root){
    Stack<TreeNode> stack = new Stack<>();
    List<TreeNode> visited = new ArrayList<>();

    stack.push(root);

    while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        if(node != null){
            visited.add(node);
            process(node);
            stack.push(node.right);
            stack.push(node.left);
        }
    }
}

贪心算法：当下做局部最优判断
回溯：能够回退
动态规划：最优判断+回退


二分查找
1. 目标函数的单调性
2. 存在上下界
3. 能够通过索引访问

int left = 0, right = nums.length -1;
while(left<=right){
    int mid = left + (right - left)/2;

    if(nums[mid] == target){
        return mid;
    } else if (nums[mid] < target){
        left = mid + 1;
    } else {
        right = mid -1;
    }
}



递归
public void recur(int level, Param param) {
    if (level > MAX_VALUE) {
        //process result
        return;
    }

    // current process logic
    process(param);

    // drill down
    recur(level, newParam);

    // reverse status
}

分治
public data divide_conputer(Problem problem, param1, param2 ...) {
    if(problem == null){
        // process result
        return data;
    }

    // prepare data
    data = process_data(problem);
    subProblems = split_problem(problem, data):

    // drill down, conputer_sub_problems
    subResult1 = divide_conputer(subProblems[0], param1, param2 ...);
    subResult2 = divide_conputer(subProblems[1], param1, param2 ...);
    subResult3 = divide_conputer(subProblems[2], param1, param2 ...);

    // merge subProblems
    result =  mergeProblems(subResult1, subResult2, subResult3);

    // reverse status
}


// 动态规划
1. 动态规划和递归或者分治没有根本上的区别（关键看有无最优子结构）
2. 共性：找到重复子问题
3. 差异：最优子结构，中途可以淘汰次优解


路径
int countPath(boolean[][] grid, int row, int col){
    if(!validSquare(grid, row, col)) return 0;
    if(isAtEnd(grid, row, col)) return 1;

    return countPath(grid, row+1, col) + countPath(grid, row, col + 1);
}

状态转移方程（DP方程）
opt[i,j] = opt[i+1,j] + opt[i, j+1]
完整逻辑
if (a[i][j] == "blank") {
    a[i][j] = opt[i+1,j] + opt[i, j+1];
} else {
    a[i][j] = 0;
}

动态规划关键点
1. 最优子结构 opt[n] = bestOf(opt[n-1], opt[n-2]...)
2. 存储中间状态 opt[i]
3. 递推公式（状态转移方程、DP方程），自底向上
    Fib：opt[i] = opt[i-1] + opt[i-2]
    二维路径：opt[i,j] = opt[i+1,j] + opt[i, j+1] (且判断a[i][j]判断是否为空地)



字典树
基本性质
1. 节点本身不存完整的单词
2. 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的单词
3. 每个节点的所有子节点路径代表的字符不相同

核心思想
空间换时间，利用字符串的公共前缀来降低查询时间的开心以达到提高效率的目的



位运算
1. 将x的最右边的n位清零 x & ( ~0 <<  n)
2. 获取x的第n位置(0或者1) (x << n) & 1
3. 获取x的第n位的幂值：x & (1 << (n-1))
4. 仅将第n位置为1：x|(1<<n)
5. 仅将第n位置为0：x&(~(1<<n))

判断奇偶性
x&1 =1 奇数
x&1 =0 偶数

x>>1  为x/2

x = x*(x-1) 清零最低位的1

x & -x =》 得到最低位的1

x & ~x => 0



快速排序
public void quickSort(int[] array, int begin, int end) {
    if (begin >= end) return;
    int pivot = partition(array, begin, end);

    quickSort(array, begin, pivot - 1);
    quickSort(array, pivot + 1, end);

}

public int partition(int a, int begin, int end) {
    int pivot = end, counter = begin;
    for(int i = begin; i < end; i++) {
        if(a[i] < a[pivot]) {
            int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
            counter++;
        }
    }

    int temp = a[counter]; a[counter] = a[pivot]; a[pivot] = temp;
    return counter;
}


归并排序
public void mergeSort(int[] array, int begin, int end) {
   if(begin >= end) return;

   int mid = begin + ((end - begin) >> 1);

   mergeSort(array, begin, mid);
   mergeSort(array, mid + 1, end);
   merge(array, begin, mid, end);
}

public void merge(int[] a, int begin, int end) {
    int[] temp = new int[end - begin +1];
    int i = begin, j = mid + 1, k = 0;

    while(i <= mid && j <= end) {
        temp[k++] = a[i] < a[j]? a[i++] : a[j++];
    }

    while(i <= mid) {
        temp[k++] = a[i++];
    }

    while(j <= end) {
        temp[k++] = a[j++]
    }

    for (int p = 0; p < temp.length; p++){
        a[begin + p] = temp[p];
    }

//  System.arraycopy(a, begin, temp, 0, temp.length)
}


反转字符串
char[] chars = s.toArrayChars();
for(int i=0, j= s.length-1; i < j; i++; j++) {
    char temp = chars[i]; chars[i] = chars[j]; chars[j] = temp;
}

for( int i = 0; i < length -1; i++) {
    for (int j = i+1; j < length; j++) {

    }
}

public void reverse(char[] chs, int i, int j){
    while(i < j) {
        int temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}

反转单词
public void reverseWords(char[] chs, n){
    int i = 0, j = 0;
    while(i < n) {
        while(i < j && i < n && chs[i] == ' ') i++;
        while(j < i && j < n && chs[j] != ' ') j++;
        reverse(chs, i, j-1)
    }
}


滑动窗口
public void minWindow(String s, String t){

    int[] hash = new int[256];

    for(char c : t.toCharArray()){
        hash[c]++;
    }

    int left = 0, right = 0, count = t.length();
    while(left < s.length){
        if(hash[right++]-- >= 1) count--;

        if(count == 0) {  // 找到符合条件的子字符串


        }
    }
}


198 打家劫舍


236 105
46，47