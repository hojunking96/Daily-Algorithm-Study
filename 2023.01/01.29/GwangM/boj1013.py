#01이거나 1001
#0으로 시작하면 무조건 01패턴, 1로 시작하면 아님
#100까지 확정 그뒤에 1이 나온 순간부터 바뀜 
#1이 두 번 이상 나왔다면 1001 패턴이 한번더 나왔다는 것
import sys
input=sys.stdin.readline
t=int(input())
for _ in range(t):
  pattern=input().rstrip()
  le=len(pattern)
  p1=False #01
  p2=False #10 0+ 1+
  i=0
  while i<le:
    if p1==False and p2==False:
      if pattern[i]=='0':
        p1=True
      else:
        p2=True
    elif p1==True:
      if pattern[i]=='1':
        p1=False
        if i==le-1:
          print("YES")
          break
      else:
        print("NO")
        break
    else:
      if i>le-3:
        print("NO")
        break
      if pattern[i]=='0' and pattern[i+1]=='0':        
        while pattern[i]=='0':
          i+=1
          if i==le:
            print("NO")
            break
        if i==le:
          break
        while pattern[i]=='1':
          i+=1
          if i==le:
            print("YES")
            break
        if i==le-1:
          print("NO")
          break
        if i==le:
          break
        if pattern[i+1]=='0':
          if not(pattern[i-1]=='1' and pattern[i-2]=='1'):
            print("NO")
            break
          else: 
            p2=False
            i-=2
        else:
          p2=False
          i-=1
      else:
        print("NO")
        break
    i+=1
    if i==le:
      print("NO")