from collections import deque
import sys
input = sys.stdin.readline
queue = deque()

m,n,h=map(int, input().split())
tomato=[]
zero=0
move=[[1,0,0],[-1,0,0],[0,1,0],[0,-1,0],[0,0,1],[0,0,-1]]
for i in range(h):
  tomato.append([])
  for j in range(n):
    tomato[i].append(list(map(int, input().split())))
days=0
#bfs
def change(queue):
  global days
  cpy=queue[-1]
  while queue:
    rr=queue.popleft()
    for i in range(6):
      dz=rr[0]+move[i][0]
      dy=rr[1]+move[i][1]
      dx=rr[2]+move[i][2]
      if 0<=dz< h and 0<=dy<n and 0<=dx<m and tomato[dz][dy][dx]==0:
        tomato[dz][dy][dx]=1
        queue.append([dz,dy,dx])
    if rr==cpy and queue:
      days+=1
      cpy.clear()
      if queue:
        cpy=queue[-1]

for i in range(h):
  for j in range(n):
    for k in range(m):
      if tomato[i][j][k]==0:
        zero+=1
      if tomato[i][j][k]==1:
        queue.append([i,j,k]) 
if queue:
  change(queue)
cnt=0
for i in range(h):
  for j in range(n):
    for k in range(m):
      if tomato[i][j][k]==0:
        cnt+=1
if zero==0:
  print(0)
elif cnt>0:
  print(-1)
else:
  print(days)
