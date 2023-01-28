import sys

input=sys.stdin.readline
n,m=map(int,input().split())

ary=[]
sum=[0]
for i in range(n):
  ary.append(list(map(int,input().split())))
  for j in range(n):
    if i==0:
      sum.append(sum[-1]+ary[i][j]) #sum[1]=[0][0]까지 합
    elif j==0:
      sum.append(sum[-n]+ary[i][j])
    else:
      sum.append(sum[-1]+ary[i][j]+sum[-n]-sum[-n-1])
      
sum.pop(0)

for i in range(m):
  x1,y1,x2,y2=map(int,input().split())
  if y1==1:
    if x1==1:
      print(sum[n*x2+y2-n-1])
    else:
      print(sum[n*x2+y2-n-1]-sum[n*x1+y2-2*n-1])
  elif x1==1:
    print(sum[n*x2+y2-n-1]-sum[n*x2+y1-n-2])
  else:
    print(sum[n*x2+y2-n-1]-sum[n*x2+y1-n-2]-sum[n*x1+y2-2*n-1]+sum[n*x1+y1-2*n-2])
  
