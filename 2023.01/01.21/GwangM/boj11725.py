from collections import deque
n=int(input())
tree=[]
parent=[]
for i in range(n+1):
  tree.append(set())
  parent.append(0)
for _ in range(n-1):
  x,y=map(int, input().split())
  tree[x].add(y)
  tree[y].add(x)

def bfs(tree):  #가장 가까운 노드부터 찾으면 그 노드의 이전 노드가 부모가 된다.
  queue=deque()
  queue.append(1)
  visited=set()
  visited.add(1)
  while queue:
    now = queue.popleft()
    for i in tree[now]:
      if parent[i]==0:
        parent[i]=now
      if i not in visited:
        visited.add(i)
        queue.append(i)
bfs(tree)
for i in range(2,n+1):
  print(parent[i])

