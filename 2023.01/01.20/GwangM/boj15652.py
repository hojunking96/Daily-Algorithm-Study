#뒤의 수는 앞의 수 이상이어야 하므로 앞의 수부터 N까지 반복하도록
result=[]
def solve(n,m):
  
  if m!=1:
    for i in range(1,n+1):
     if result==[] or i>=max(result):
      result.append(i)
      solve(n,m-1)
      result.pop()
  else:
    for i in range(1,n+1):
     if result==[] or i >= max(result):
      result.append(i)
      temp=result[:]
      temp.sort()
      for j in temp:
        print(j,end = ' ')  
      if temp[0]!=n:
        print()
      result.pop()
n,m=map(int,input().split())
#n까지의 수 중에 m개를 뽑는다.
solve(n,m)