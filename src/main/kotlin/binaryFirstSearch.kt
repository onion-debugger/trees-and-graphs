import java.util.*

fun traverse(root: TreeNode) : List<List<Int>> {
    val resultList = mutableListOf<List<Int>>()

    if (root == null) return resultList

    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        val currentLevel = mutableListOf<Int>()

        for (i in 0 until size) {
            val currentNode: TreeNode = queue.poll()
            // add node to the current level
            currentLevel.add(currentNode.value)

            // Insert the children of the current node in queue
            if (currentNode.left != null) queue.offer(currentNode.left)
            if (currentNode.right != null) queue.offer(currentNode.right)
        }
        resultList.add(currentLevel)
    }
    return resultList
}

fun reverseTraversal(root: TreeNode) : List<List<Int>> {
    val resultList: MutableList<List<Int>> = LinkedList<List<Int>>()

    if (root == null) return resultList

    val queue: Queue<TreeNode> = LinkedList<TreeNode>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        val currentLevel = arrayListOf<Int>()

        for (i in 0 until size) {
            val currentNode = queue.poll()
            currentLevel.add(currentNode.value)

            if (currentNode.left != null) queue.offer(currentNode.left)
            if (currentNode.right != null) queue.offer(currentNode.right)
        }
        resultList.add(0, currentLevel)
    }
    return resultList
}

fun zigzagTraversal(root: TreeNode) : List<List<Int>> {
    val outputArray = arrayListOf<List<Int>>()

    if (root == null) return outputArray

    val queue = LinkedList<TreeNode>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val size = queue.size
        val treeLevel = arrayListOf<Int>()

        for (i in 0 until size) {
            val currentNode = queue.poll()
            if (size % 2 == 0) {
                treeLevel.add(0, currentNode.value)
            } else {
                treeLevel.add(currentNode.value)
            }
            if (currentNode.left != null) queue.offer(currentNode.left)
            if (currentNode.right != null) queue.offer(currentNode.right)
        }
        outputArray.add(treeLevel)
    }
    return outputArray
}

fun averageOfTreeLevels(root: TreeNode) : ArrayList<Double> {
    val outputArray = arrayListOf<Double>()

    if (root == null) return outputArray
    val queue = LinkedList<TreeNode>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val treeLevelValues = arrayListOf<Int>()
        var sumOfAllValueInLevels = 0.0

        for (i in 0 until levelSize) {
            val currentNode = queue.poll()
            treeLevelValues.add(currentNode.value)
            sumOfAllValueInLevels += currentNode.value

            if (currentNode.left != null) queue.offer(currentNode.left)
            if (currentNode.right != null) queue.offer(currentNode.right)
        }

        outputArray.add(sumOfAllValueInLevels / levelSize)
    }
    return outputArray
}

fun minimumDepthOfTree(root: TreeNode) : Int {
    if (root == null) return 0

    var minimumDepth = 0
    val queue = LinkedList<TreeNode>()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        minimumDepth++
        val levelSize = queue.size

        for (i in 0 until levelSize) {
            val currentNode = queue.poll()

            // check if it is leaf node
            if (currentNode.left == null && currentNode.right == null) {
                return minimumDepth
            }

            if (currentNode.left != null) queue.add(currentNode.left!!)
            if (currentNode.right != null) queue.add(currentNode.right!!)
        }
    }

    return minimumDepth
}

fun main() {
    val root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.right!!.left = TreeNode(10)
    root.right!!.right = TreeNode(5)

    val result = minimumDepthOfTree(root)
    println("Tree Minimum Depth: $result")
}
