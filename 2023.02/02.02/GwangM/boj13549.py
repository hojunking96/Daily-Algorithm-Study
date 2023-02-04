from collections import deque
n,k=map(int,input().split())

if n>=k:
  print(n-k)
else:
  distance=0
  visited=[False]*100001
  arr_n=deque([(n,distance)])
  visited[n]=True

  while arr_n:
    n,distance=arr_n.popleft()
#    print(distance)
    if n==k:
      print(distance)
      break
    temp=2*n
    if temp!=0:
     while(temp<=100000):
      if not visited[temp]:
        if temp==k:
          print(distance)
          break
        arr_n.append([temp,distance])
        visited[temp]=True
      temp*=2
    if temp==k:
      break
    if n>1 and not visited[n-1]:
      if n-1==k:
        print(distance+1)
        break
      visited[n-1]=True
      arr_n.append([n-1,distance+1])
    if n!=100000 and not visited[n+1]:
      if n+1==k:
        print(distance+1)
        break
      visited[n+1]=True
      arr_n.append([n+1,distance+1])
