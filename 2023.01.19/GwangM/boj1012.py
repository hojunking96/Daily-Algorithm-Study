import sys
from collections import deque
input=sys.stdin.readline
t=int(input())
for _ in range(t):
  m,n,k=map(int,input().split())
  cabbage=[[0 for j in range(n)]for i in range(m)]
  for _ in range(k):
    i,j=map(int, input().split())
    cabbage[i][j]=1
  count=0
  #다른 방법도 확인
  queue=deque()
  for i in range(m):
    for j in range(n):
      if cabbage[i][j]==1:
        count+=1
        cabbage[i][j]=0
        queue.append([i,j])
        #pop이후에 0으로 바꾸는 방식은 시간이 더 오래 걸리기 때문에 append하기 전에 0으로 바꿔주었다.
        while queue:
         dx,dy = queue.popleft()
         if not dx==0:
            if cabbage[dx-1][dy]==1:
              cabbage[dx-1][dy]=0
              queue.append([dx-1,dy])
         if not dy==0:
            if cabbage[dx][dy-1]==1:
              cabbage[dx][dy-1]=0
              queue.append([dx,dy-1])
         if not dx==m-1:
            if cabbage[dx+1][dy]==1:
              cabbage[dx+1][dy]=0
              queue.append([dx+1,dy])
         if not dy==n-1:
            if cabbage[dx][dy+1]==1:
              cabbage[dx][dy+1]=0
              queue.append([dx,dy+1])

  print(count)
  count=0  

#bfs로 풀어보았다.
