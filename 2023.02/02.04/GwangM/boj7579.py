import sys
input=sys.stdin.readline
n,m=map(int,input().split())
byte=[0]+list(map(int,input().split()))
cost=[0]+list(map(int,input().split()))

d=[([0]*(10001))for _ in range(n+1)]
result=sum(cost)
#배낭문제처럼 i는 프로그램 = n, j는 비용
for i in range(1,n+1):
  b=byte[i]
  c=cost[i]
  for j in range(10001):
    if j<c:
      d[i][j]=d[i-1][j]
    else:
      d[i][j]=max(d[i-1][j-c]+b,d[i-1][j])
    if d[i][j]>=m:
      result=min(result,j)

print(result)
