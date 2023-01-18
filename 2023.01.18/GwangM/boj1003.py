ary=[[1,0],[0,1]]

t=int(input())
for i in range(2,41):
  ary.append([ary[i-2][0]+ary[i-1][0],ary[i-2][1]+ary[i-1][1]])

for i in range(t):
  n=int(input())
  print(ary[n][0],ary[n][1])