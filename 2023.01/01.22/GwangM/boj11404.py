n=int(input())
m=int(input())
inf=float("INF")
bus=[[inf for i in range(n+1)]for j in range(n+1)]
for _ in range(m):
  a,b,c=map(int,input().split())
  if bus[a][b]>c:
    bus[a][b]=c
for i in range(1,n+1):
  bus[i][i]=0

for k in range(1,n+1):
  for i in range(1,n+1):
    for j in range(1,n+1):
      bus[i][j]=min(bus[i][j],bus[i][k]+bus[k][j])

for i in range(1,n+1):
  for j in range(1,n+1):
    if bus[i][j]==inf:
      print(0,end=' ')
    else:
      print(bus[i][j],end=' ')
  print()