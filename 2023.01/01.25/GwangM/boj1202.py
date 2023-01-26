import sys
import heapq
input=sys.stdin.readline
n,k=map(int,input().split())
gem=[]
for _ in range(n):
  heapq.heappush(gem, list(map(int, input().split() ) ))
bag=[]
for _ in range(k):
  c=int(input())
  bag.append(c)
bag.sort()

sum=0
temp=[]

#heappop을 하면 heapq의 순서가 달라지기 때문에
#for j in gem에서 j의 순서가 원했던 것과 달라짐
# for i in bag:
#   for j in gem:
#     if i<j[0]:
#       break
#     else:
#       heapq.heappush(temp,-heapq.heappop(gem)[1])
#   if temp:
#     sum-=heapq.heappop(temp)
  
for i in bag:
  while gem and i>=gem[0][0]:
      heapq.heappush(temp,-heapq.heappop(gem)[1])
  if temp:
    sum-=heapq.heappop(temp)
  elif not gem:
    break
print(sum)