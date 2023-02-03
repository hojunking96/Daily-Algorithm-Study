import heapq
import sys
input=sys.stdin.readline
v,e=map(int,input().split())
visited=[False]*(v+1)
edge=[[]for _ in range(v+1)]
heap=[[0,1]]
for _ in range(e):
  a,b,c=map(int,input().split())
  edge[a].append([c,b])
  edge[b].append([c,a])
result=0
count=0
while heap:
  if count==v:
    break
  weight, start=heapq.heappop(heap)
  if not visited[start]:
    visited[start]=True
    result+=weight
    count+=1
    for i in edge[start]:
      heapq.heappush(heap,i)
print(result)