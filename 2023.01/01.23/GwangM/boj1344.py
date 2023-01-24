a=int(input())
b=int(input())
#적어도 한 팀이 소수일 확률 = 1 - 둘다 소수가 아닐 확률
#소수가 아닌 수는 0,1,4,6,8,9,10,12,14,15,16,18
fact=[]
for i in range(19):
  if i==0 or i==1:
    fact.append(1)
  else:
    fact.append(i*fact[-1])
ary=[0,1,4,6,8,9,10,12,14,15,16,18]
def solve(per):
  sum=0
  for i in ary:
    temp = (per**i)*((1-per)**(18-i))
    temp2 = fact[18]/fact[18-i]/fact[i]
    sum+=temp*temp2
  return sum
print(1-(solve(0.01*a)*solve(0.01*b)))