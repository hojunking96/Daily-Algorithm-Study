t=int(input())
#그리디 알고리즘
#재귀적으로
coin=[1000000000000000,100000000000000,25000000000000,10000000000000,1000000000000,250000000000,100000000000,10000000000,2500000000,1000000000,100000000,25000000,10000000,1000000,250000,100000,10000,2500,1000,100,25,10,1]
def solve(idx,cost):
  if cost%coin[idx]==0:
    return cost/coin[idx]
  elif str(coin[idx])[0]=='2':
    tem=idx
    if cost//coin[idx]==0:
      tem=idx+1
    q1=cost//coin[idx+1]
    return min(idx+1-tem+solve(tem,cost-(coin[idx]*(idx+1-tem))), q1+solve(idx+2,cost-(q1*coin[idx+1])))
  else:
    q=cost//coin[idx]
    return(q+solve(idx+1,cost-(q*coin[idx])))
for _ in range(t):
  c=int(input())
  le=len(coin)
  for i in range(le):
    if c//coin[i]!=0:
      temp=i
      break
  print(int(solve(temp,c)))