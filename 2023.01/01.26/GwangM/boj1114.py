l,k,c=map(int,input().split())
#최대 c번 자를 수 있다.
cut = list(map(int,input().split()))
cut.append(0)
cut.append(l)
cut.sort()
def solve(n):
  count=0
  cut_start=l
  prev=[]
  first=0

  for i in range(len(cut)-1,-1,-1):
    diff=cut[i]-cut[i-1]
    total=cut_start-cut[i]
    if diff>n:
      return 100000,0
    elif total>n:
      cut_start=cut[i+1]
      prev.append(cut[i+1])
      count+=1
    
  if count<c:
    first=cut[1]
  else:
    first=prev[-1]
  return count,first

start=0
end=l
result=0
first_cut=0
while start<=end:
  mid=(start+end)//2
  count,first=solve(mid)
  if c<count:
    start=mid+1
  else:
    result=mid
    first_cut=first
    end=mid-1
print(result,first_cut)
